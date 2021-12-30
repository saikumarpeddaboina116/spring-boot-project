package com.bookstore.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookstoreApplicationTest {

    @Test
    void main() {
        String[] args = new String[0];
        BookstoreApplication.main(args);
        assertEquals(args, BookstoreApplication.args2);
    }
}