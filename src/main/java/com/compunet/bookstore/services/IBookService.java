package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> getAll();
    void deleteById(Long id);
    Book edit(Book book);
    void sort();
}
