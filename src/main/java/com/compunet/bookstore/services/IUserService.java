package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.models.User;

public interface IUserService {
    User add(User user);
    User login(User user);
}