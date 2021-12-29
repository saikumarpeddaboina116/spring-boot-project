package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Repository.OrderDAORepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderServiceJPA {
    private  final OrderDAORepo orderDAORepo;

    public OrderServiceImpl(OrderDAORepo orderDAORepo) {
        this.orderDAORepo = orderDAORepo;
    }

    @Override
    public List<OrderDetails> findAll() {
        return orderDAORepo.findAll();
    }

    @Override
    public void save(OrderDetails theOrder) {
    orderDAORepo.save(theOrder);
    }

    @Override
    public List<OrderDetails> findByUsername(String username) {
        return orderDAORepo.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username, int id) {
    orderDAORepo.deleteByUsername(username,id);
    }

    @Override
    public void deleteByBookId(int id) {
    orderDAORepo.deleteByBookId(id);
    }

    @Override
    public void deleteById(int id) {
        orderDAORepo.deleteById(id);
    }
}
