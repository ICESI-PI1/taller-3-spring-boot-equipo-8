package com.compunet.bookstore.persistence.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Autor {
    private final Long id;
    private final String name;
    private final String nationality;

    @Override
    public String toString() {
        return "Book(id: " + id + "; name: " + name + "; nationality: " + nationality +")";
    }
}
