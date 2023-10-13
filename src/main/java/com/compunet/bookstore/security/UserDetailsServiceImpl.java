package com.compunet.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.impl.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      User user = userRepository.findByUsername(username);
      return UserDetailsImpl.build(user);
    } catch (Exception e) {
      throw new UsernameNotFoundException("Username not found");
    }

  }
}