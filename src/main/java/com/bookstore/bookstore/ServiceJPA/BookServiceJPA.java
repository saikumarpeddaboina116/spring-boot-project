package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.Book;

import java.util.List;

public interface BookServiceJPA {
    void save(Book book);
    Book findById(int theId);
    List<Book> findAll();
    void deleteById(int theId);

}
