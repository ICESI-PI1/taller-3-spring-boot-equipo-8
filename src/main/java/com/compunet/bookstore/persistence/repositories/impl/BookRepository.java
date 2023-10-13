package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository implements IBookRepository {
    List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }
    
    @Override
    public Book edit(Book book){
        Book existingBook = findById(book.getId()).orElse(null);
        books.remove(existingBook);
        books.add(book);
        return existingBook;
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream().filter(b-> Objects.equals(b.getId(), id)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(toRemove -> books.remove(toRemove));
    }

    @Override
    public void sort(){
        Comparator<Book> idComparator = Comparator.comparingLong(Book::getId);
        books.sort(idComparator);
    }

    @Override
    public List<Book> getBooksByAutor(Long autorId){
        return books.stream().filter(b -> Objects.equals(b.getAutor().getId(), autorId)).toList();
    }

    @Override
    public void editAutor(Autor autor) {
        for (Book books: books) {
            Autor autor1 = books.getAutor();
            if (autor1.getId().equals(autor.getId())){
                autor1.setName(autor.getName());
                autor1.setNationality(autor.getNationality());
            }
        }
    }
}