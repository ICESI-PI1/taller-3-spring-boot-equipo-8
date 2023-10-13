package com.compunet.bookstore.persistence.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private Long id;
    private final String username;
    private final String password;
}