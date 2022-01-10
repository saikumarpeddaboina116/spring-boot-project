package com.bookstore.bookstore.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderDetailsTest {

    @Test
    void getId() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(10);
        assertEquals(10, orderDetails.getId());
    }

    @Test
    void getBookId() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setBookId(10);
        assertEquals(10, orderDetails.getBookId());
    }

    @Test
    void getUsername() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setUsername("sai");
        assertEquals("sai", orderDetails.getUsername());
    }

    @Test
    void setId() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        orderDetails.setId(10);
        assertEquals(10, orderDetails.getId());
    }

    @Test
    void setBookId() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        orderDetails.setBookId(10);
        assertEquals(10, orderDetails.getBookId());
    }

    @Test
    void setUsername() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        orderDetails.setUsername("sai");
        assertEquals("sai", orderDetails.getUsername());
    }
}