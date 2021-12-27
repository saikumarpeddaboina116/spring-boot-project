package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.Book;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;

import java.util.List;

public interface BookService {
   public void saveBook(Book book);
   public Book getBook(int id);
    public void delete(int id);
    public List<Book> getBooks();

    void saveOrder(OrderDetails order);
//    List<Book> getAll();
//
//    Book getBook(int id);
//
//    void save(Book book);
//
//    void saveOrder(Order order);
//
//    void delete(int id);
}
