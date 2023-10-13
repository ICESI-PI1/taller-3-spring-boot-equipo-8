package com.compunet.bookstore.persistence.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Book {
    public Book() {

    }

    public Book(Long id,String title, Date realeaseDate, Autor autor){
        this.id = id;
        this.title = title;
        this.realeaseDate = realeaseDate;
        this.autor = autor;
    }

    private Long id;

    private String title;
    private Date realeaseDate;

    private Autor autor;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRealeaseDate() {
        return realeaseDate;
    }

    public void setRealeaseDate(Date realeaseDate) {
        this.realeaseDate = realeaseDate;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book(id: " + id + "; title: " + title + "; realease date: " + realeaseDate + "; author: " + autor.getName() + ")";
    }

}
