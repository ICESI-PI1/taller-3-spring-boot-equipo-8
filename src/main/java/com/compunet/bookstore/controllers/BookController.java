package com.compunet.bookstore.controllers;

import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "list_books"; 
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book);
        return "edit_book";
    }
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam Date realeaseDate,
                           @RequestParam String author){
        Book book = new Book(title,realeaseDate,author);
        book.setId(id);
        bookService.edit(book);
        bookService.sort();
        return "redirect:/";
    }
    @GetMapping("/detailed-book/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book);
            return "detailed-book";
        } else {
            return "error";
        }
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/add-book")
    public String addBook() {
        return "add_book";
    }
    @PostMapping("/save-book")
    public String saveBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam Date realeaseDate,
                           @RequestParam String author){
        Book book = new Book(title,realeaseDate,author);
        bookService.save(book);
        return "redirect:/";
    }
}
