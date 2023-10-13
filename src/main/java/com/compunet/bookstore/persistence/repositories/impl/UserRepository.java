package com.compunet.bookstore.persistence.repositories.impl;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.IUserRepository;

import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();
    private Long counter =1L;

    @Override
    public User save(User user) {
        counter++;
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void sort(){
        Comparator<User> idComparator = Comparator.comparingLong(User::getId);
        users.sort(idComparator);
    }

    @Override
    public User matchCredentials(User user) {
        return users.stream().filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())).findFirst().orElse(null);
    }
}