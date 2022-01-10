package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.User;

import java.util.List;

public interface UserServiceJPA {
    void save(User theUser);
    List<User> findAll();
    User findById(String username);

}
