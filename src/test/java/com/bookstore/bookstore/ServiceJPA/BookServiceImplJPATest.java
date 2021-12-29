package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceImplJPATest {

        @Autowired
        BookServiceJPA bookServiceJPA;
        @MockBean
        BookRepository bookRepository;
    @Test
    void save() {
        Book book=new Book(1,"HARRYPOTTER",200.5,123);
        bookServiceJPA.save(book);
        verify(bookRepository,times(1)).save(book);
    }

    @Test
    void findById() {
        Book book=new Book(1,"HARRYPOTTER",200.5,123);
        Optional<Book> userById = Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(userById);
        assertEquals(bookServiceJPA.findById(1),book);
    }

    @Test
    void findAll() {
        when(bookRepository.findAll()).thenReturn(Stream.of(
                new Book(1,"HARRYPOTTER",200.5,123),
                new Book(2,"HARRYPOTTER1",2002.5,3123)
        ).collect(Collectors.toList()));
        assertEquals(2,bookServiceJPA.findAll().size());
    }
}