package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.OrderDetails;

import java.util.List;

public interface OrderServiceJPA {
    List<OrderDetails> findAll();

    void save(OrderDetails theOrder);


    List<OrderDetails> findByUsername(String username);

    void deleteByUsername(String username, int theId);
    void deleteByBookId(int id);

    void deleteById(int id);
}
