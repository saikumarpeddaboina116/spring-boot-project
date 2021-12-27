package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.OrderDetails;

import java.util.List;

public interface OrderService {
    List<OrderDetails> findAll();

    void save(OrderDetails theOrder);


}
