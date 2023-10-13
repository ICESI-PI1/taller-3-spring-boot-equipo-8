package com.compunet.bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.IUserRepository;
import com.compunet.bookstore.services.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User add(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User login(User user) throws UsernameNotFoundException {
        if(user.getUsername() == null || user.getPassword() == null) {
            throw new UsernameNotFoundException("Campos vacíos");
        }

        return userRepository.matchCredentials(user);
    }
}
