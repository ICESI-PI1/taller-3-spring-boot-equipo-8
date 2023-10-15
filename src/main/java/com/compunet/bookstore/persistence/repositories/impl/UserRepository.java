package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.IUserRepository;

import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User matchCredentials(User user) {
        return users.stream().filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())).findFirst().orElse(null);
    }

    public Optional<User> findByUsername(String name) {
        return users.stream().filter(u -> u.getUsername().equals(name)).findFirst();
    }
}