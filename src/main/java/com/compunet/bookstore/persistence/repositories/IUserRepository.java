package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.User;

import java.util.List;

public interface IUserRepository {
    User save(User user);
    List<User> getAll();
    User matchCredentials(User user);
}
