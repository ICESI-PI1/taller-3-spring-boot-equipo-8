package com.compunet.bookstore.persistence.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Book {
    private Long id;
    private final String title;
    private final Date realeaseDate;
    private final String author;

    @Override
    public String toString() {
        return "Book(id: " + id + "; title: " + title + "; realease date: " + realeaseDate + "; author: " + author + ")";
    }
    public void setId(Long id){
        this.id=id;
    }
}
