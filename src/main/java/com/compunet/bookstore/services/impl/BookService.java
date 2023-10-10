package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import com.compunet.bookstore.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    /* Esta vez se puede usar autowired, no es necesario usar un setter.
    * Spring va a inyectar un bean de tipo IBookRepository automaticamente
    * Eso se puede observar en el log 'BEANS BUILT': Hay un BookRepository que
    * fue creado por Spring (por la anotacion @Repository). El frameork busca entre los beans
    * si hay alguno que pueda asignar a IBookRepository y al encontrarlo lo asigna aca */
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public String toString() {
        return ("BookService (repo:" + bookRepository.toString() + ")");
    }

    @Override
    public Book edit(Book book){
        return bookRepository.edit(book);
    }
    @Override
    public void sort(){
        bookRepository.sort();
    }
}
