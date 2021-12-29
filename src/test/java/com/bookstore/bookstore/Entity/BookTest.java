package com.bookstore.bookstore.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookTest {

    @Test
    void getId() {
        Book book = new Book();
        book.setId(1);
        assertEquals(1, book.getId());
    }

    @Test
    void getTitle() {
        Book book = new Book();
        book.setTitle("sai");
        assertEquals("sai", book.getTitle());
    }

    @Test
    void getPrice() {
        Book book = new Book();
        book.setPrice(100.5);
        assertEquals(100.5, book.getPrice());
    }

    @Test
    void getNoOfCopies() {
        Book book = new Book();
        book.setNoOfCopies(200);
        assertEquals(200, book.getNoOfCopies());
    }

    @Test
    void setId() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        book.setId(10);
        assertEquals(10, book.getId());
    }

    @Test
    void setTitle() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        book.setTitle("sai");
        assertEquals("sai", book.getTitle());
    }

    @Test
    void setPrice() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        book.setPrice(100.5);
        assertEquals(100.5, book.getPrice());
    }

    @Test
    void setNoOfCopies() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        book.setNoOfCopies(200);
        assertEquals(200, book.getNoOfCopies());
    }
}