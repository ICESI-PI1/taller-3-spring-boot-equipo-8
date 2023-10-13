package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    Book save(Book book);
    Book edit(Book book);

    List<Book> getAll();
    Optional<Book> findById(Long id);
    void deleteById(Long id);

    void sort();

    List<Book> getBooksByAutor(Long autorId);

    void editAutor(Autor autor);
}
