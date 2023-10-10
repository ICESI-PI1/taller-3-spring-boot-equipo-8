package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository implements IBookRepository {
    List<Book> books = new ArrayList<>();
    private Long counter =1L;

    @Override
    public Book save(Book book) {
            book.setId(counter);
            counter++;
            books.add(book);
            return book;
    }
    @Override
    public Book edit(Book book){
        Book existingBook = findById(book.getId()).orElse(null);
        books.remove(existingBook);
        books.add(book);
        return book;
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
}