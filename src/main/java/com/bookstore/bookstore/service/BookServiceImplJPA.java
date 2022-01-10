package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.exception.MyException;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImplJPA implements BookServiceJPA{
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImplJPA(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result=bookRepository.findById(theId);
       Book book=null;
       if(result.isPresent())
       {
           book=result.get();
       }

        else {

        throw new MyException("Did not find Book with id - " + theId);
    }
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}
