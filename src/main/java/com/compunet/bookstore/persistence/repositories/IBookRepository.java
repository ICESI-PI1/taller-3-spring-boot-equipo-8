package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
<<<<<<< HEAD
    Book save(Book book);
    Book edit(Book book);
=======
    void save(Book book);

    void edit(Book book);
>>>>>>> b4d605f35f1a1b5f097a3a1fd9d668fd60710e67

    List<Book> getAll();
    Optional<Book> findById(Long id);
    void deleteById(Long id);

    void sort();

    List<Book> getBooksByAutor(Long autorId);

    void editAutor(Autor autor);
}
