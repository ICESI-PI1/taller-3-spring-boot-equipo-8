package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository {
    List<Autor> getAllAuthor();
    Optional<Autor> getDetails(Long autorId);
    void createAutor(Autor autor);
    void editAutor(Autor autor);
    void deleteAutor(Long id);
    List<Book> getBookByAutor(Long autorId);
    Optional<Autor> findById(Long autorId);
}

