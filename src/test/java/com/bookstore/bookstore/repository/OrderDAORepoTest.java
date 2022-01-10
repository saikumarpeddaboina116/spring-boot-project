package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.OrderDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderDAORepoTest {
    @MockBean
    private OrderDAORepo orderDAORepo;

    @Test
    void findByUsername() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        List<OrderDetails> order = List.of(orderDetails);
        when(orderDAORepo.findByUsername("saikumar")).thenReturn(order);
        assertEquals(orderDAORepo.findByUsername("saikumar"), order);
    }

    @Test
    void deleteByUsername() {
        orderDAORepo.deleteByUsername("saikumar", 1);
        verify(orderDAORepo, times(1)).deleteByUsername("saikumar", 1);
    }

    @Test
    void deleteByBookId() {
        orderDAORepo.deleteByBookId(1);
        verify(orderDAORepo, times(1)).deleteByBookId(1);
    }
}