package com.compunet.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.security.JwtGenerator;
import com.compunet.bookstore.services.IUserService;

import jakarta.annotation.PostConstruct;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private IUserService userService;

    @PostConstruct
    private void init() {
        userService.add(new User("TestUser", "1234"));
        userService.add(new User("AnotherUser", "123456"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.add(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User userData = userService.login(user);

            if(userData == null){
                throw new UsernameNotFoundException("Credenciales incorrectas");
            }

            Map<String, String> token = jwtGenerator.generateToken(userData);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}