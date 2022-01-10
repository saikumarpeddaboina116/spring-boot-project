package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.OrderDetails;
import com.bookstore.bookstore.repository.OrderDAORepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderServiceJPA orderServiceJPA;
    @MockBean
    OrderDAORepo orderDAORepo;

    @Test
    void findAll() {
        when(orderDAORepo.findAll()).thenReturn(Stream.of(
                new OrderDetails(1, 1, "saikumar"),
                new OrderDetails(2, 2, "saikumar")
        ).collect(Collectors.toList()));
        assertEquals(2, orderServiceJPA.findAll().size());
    }


    @Test
    void save() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        orderServiceJPA.save(orderDetails);
        verify(orderDAORepo, times(1)).save(orderDetails);

    }

    @Test
    void findByUsername() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        List<OrderDetails> order = List.of(orderDetails);
//        OrderDetails order =orderDetails;
        when(orderServiceJPA.findByUsername("saikumar")).thenReturn(order);
        assertEquals(orderDAORepo.findByUsername("saikumar"), order);
    }

    @Test
    void deleteByUsername() {
        orderServiceJPA.deleteByUsername("saikumar", 1);
        verify(orderDAORepo, times(1)).deleteByUsername("saikumar", 1);
    }

    @Test
    void deleteByBookId() {
        orderServiceJPA.deleteByBookId(1);
        verify(orderDAORepo, times(1)).deleteByBookId(1);
    }

    @Test
    void deleteById() {
        orderServiceJPA.deleteById(1);
        verify(orderDAORepo, times(1)).deleteById(1);
    }

    @Test
    void testFindAll() {
        when(orderDAORepo.findAll()).thenReturn(Stream.of(
                new OrderDetails(1, 1, "saikumar"),
                new OrderDetails(2, 2, "saikumar")
        ).collect(Collectors.toList()));
        assertEquals(2, orderServiceJPA.findAll().size());
    }

    @Test
    void testSave() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        orderServiceJPA.save(orderDetails);
        verify(orderDAORepo, times(1)).save(orderDetails);
    }

    @Test
    void testFindByUsername() {
        OrderDetails orderDetails = new OrderDetails(1, 1, "saikumar");
        List<OrderDetails> order = List.of(orderDetails);
//        OrderDetails order =orderDetails;
        when(orderServiceJPA.findByUsername("saikumar")).thenReturn(order);
        assertEquals(orderDAORepo.findByUsername("saikumar"), order);
    }

    @Test
    void testDeleteByUsername() {
        orderServiceJPA.deleteByUsername("saikumar", 1);
        verify(orderDAORepo, times(1)).deleteByUsername("saikumar", 1);
    }

    @Test
    void testDeleteByBookId() {
        orderServiceJPA.deleteByBookId(1);
        verify(orderDAORepo, times(1)).deleteByBookId(1);
    }

    @Test
    void testDeleteById() {
        orderServiceJPA.deleteById(1);
        verify(orderDAORepo, times(1)).deleteById(1);
    }
}