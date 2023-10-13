package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.IUserRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();

    @PostConstruct
    void init() {
        save(new User("test", "1234"));
    }

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

    public User findByUsername(String name) {
        return users.stream().filter(u -> u.getUsername().equals(name)).findFirst().get();
    }
}