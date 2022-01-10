package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.exception.MyException;
import com.bookstore.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        Optional<Book> userById = Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(userById);
        assertEquals(bookServiceJPA.findById(1), book);
    }

    @Test
    void findById_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> {
            bookServiceJPA.findById(2);
        });
        String expectedMessage = "Did not find Book with id - 2";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void findAll() {
        when(bookRepository.findAll()).thenReturn(Stream.of(
                new Book(1, "HARRYPOTTER", 200.5, 123),
                new Book(2, "HARRYPOTTER1", 2002.5, 3123)
        ).collect(Collectors.toList()));
        assertEquals(2, bookServiceJPA.findAll().size());
    }

    @Test
    void deleteById() {
        bookServiceJPA.deleteById(1);
        verify(bookRepository, times(1)).deleteById(1);
    }

    @Test
    void testSave() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        bookServiceJPA.save(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testFindById() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        Optional<Book> userById = Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(userById);
        assertEquals(bookServiceJPA.findById(1), book);
    }

    @Test
    void testFindAll() {
        when(bookRepository.findAll()).thenReturn(Stream.of(
                new Book(1, "HARRYPOTTER", 200.5, 123),
                new Book(2, "HARRYPOTTER1", 2002.5, 3123)
        ).collect(Collectors.toList()));
        assertEquals(2, bookServiceJPA.findAll().size());
    }

    @Test
    void testDeleteById() {
        bookServiceJPA.deleteById(1);
        verify(bookRepository, times(1)).deleteById(1);
    }
}