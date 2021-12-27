package com.bookstore.bookstore.service;

import com.bookstore.bookstore.Entity.Book;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.inter.BookDAO;
import com.bookstore.bookstore.inter.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

 class BookServiceImp implements BookService {
    @Autowired
    private BookDAO bookDAO;


    @Override
    @Transactional
    public void saveBook(Book book) {
    bookDAO.saveBook(book);
    }

    @Override
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }


    @Override
    public void saveOrder(OrderDetails order) {
bookDAO.saveOrder(order);
    }

    @Override
    public void delete(int id) {
    bookDAO.delete(id);
    }

    @Override
   public List<Book> getBooks() {
      return bookDAO.getBooks();
   }




}
