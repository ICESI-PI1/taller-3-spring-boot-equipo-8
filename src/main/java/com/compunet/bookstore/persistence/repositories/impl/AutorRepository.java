package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AutorRepository implements IAutorRepository {

    public static List<Autor> autors = new ArrayList<Autor>();

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Autor> getAllAuthor() {
        return autors;
    }

    @Override
    public Optional<Autor> getDetails(Long autorId) {
        return findById(autorId);
    }

    @Override
    public void createAutor(Autor autor) {
        autors.add(autor);
    }

    @Override
    public void editAutor(Autor autor) {

        for (Autor existingAutor: autors) {
            if (existingAutor.getId().equals(autor.getId())){
                existingAutor.setName(autor.getName());
                existingAutor.setNationality(autor.getNationality());
            }
        }

        bookRepository.editAutor(autor);

    }

    @Override
    public void deleteAutor(Long id) {
        findById(id).ifPresent(toRemove -> autors.remove(toRemove));
    }

    @Override
    public List<Book> getBookByAutor(Long autorId) {
        return bookRepository.getBooksByAutor(autorId);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        return autors.stream().filter(b-> Objects.equals(b.getId(), id)).findFirst();
    }
}
