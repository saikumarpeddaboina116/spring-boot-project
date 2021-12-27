package com.bookstore.bookstore.service;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.inter.OrderDAORepo;
import com.bookstore.bookstore.inter.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAORepo orderDAORepo;
    @Autowired
    public OrderServiceImpl(OrderDAORepo theOrderDAORepo)
    {
        orderDAORepo=theOrderDAORepo;
    }
    @Override
    @Transactional
    public List<OrderDetails> findAll() {

        return orderDAORepo.findAll();
    }

    @Override
    @Transactional
    public void save(OrderDetails order) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
        System.out.println(order.getUsername());
        System.out.println(order.getBookId());
    orderDAORepo.save(order);
    }
}
