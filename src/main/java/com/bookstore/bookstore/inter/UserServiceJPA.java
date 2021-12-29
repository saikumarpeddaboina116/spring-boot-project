package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.User;

import java.util.List;

public interface UserServiceJPA {
    List<User> findAll();
    void save(User theUser);



}
