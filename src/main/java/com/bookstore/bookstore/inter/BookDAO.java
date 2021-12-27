package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.Book;

import com.bookstore.bookstore.Entity.OrderDetails;

import java.util.List;

  public interface BookDAO {
   void saveBook(Book book);
    Book getBook(int id);

   List<Book> getBooks();
      void delete(int id);

      void saveOrder(OrderDetails order);


  }
