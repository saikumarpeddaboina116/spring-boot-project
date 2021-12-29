package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.User;

import java.util.List;

public interface UserServiceJPA {
    void save(User theUser);
    List<User> findAll();
    User findById(String username);

}
