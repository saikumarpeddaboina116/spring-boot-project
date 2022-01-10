package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;

import java.util.List;

public interface BookServiceJPA {
    void save(Book book);
    Book findById(int theId);
    List<Book> findAll();
    void deleteById(int theId);

}
