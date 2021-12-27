package com.bookstore.bookstore.service;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.inter.UserDAO;
import com.bookstore.bookstore.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.bookstore.Entity.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public void save(User user) {
       userDAO.save(user);
    }

    /*@Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

 /*   @Override
    public void save(User user) {
        userDAO.save(user);
    }
//    public  void save(User user);
//    // User getUser(String username);
//    void delete(int id);
//    public List<User> findAll();
*/
   @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
//    @Override
//    public List<OrderDetails> getOrderDetails() {
//        return userDAO.getOrderDetails();
//    }
//
//    @Override
//    public List<OrderDetails> getOrderDetailss(String username) {
//        return userDAO.getOrderDetailss(username);
//    }

    @Override
    public void saveRole(Authority theUser) {
userDAO.saveRole(theUser);
    }

    @Override
    public List<OrderDetails> getOrders(String username) {
        return userDAO.getOrderDetails(username);
    }

    @Override
    public void saveOrder(OrderDetails theOrder) {
        userDAO.saveOrderDetails(theOrder);
    }

    @Override
    public void deleteOrder(String username, int id) {
userDAO.deleteorder(username,id);
    }

    @Override
    public boolean checkRes(String username, Long phone) {
        return userDAO.checkRes(username,phone);
    }

    @Override
    public void deleteOrderAdmin(String name, int id) {
userDAO.deleteOrderAdmin(name,id);
    }


    /*
        @Override
        public void delete(int id) {

        }
    */
/*
    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public List<OrderDetails> getOrderDetailss(String username) {
        return userDAO.getOrderDetails(username);
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails) {
        userDAO.saveOrderDetails(theOrderDetails);

    }

    @Override
    public List<OrderDetails> getOrderDetailss() {
        return null;
    }*/
//@Override
//public void saveOrderDetails(OrderDetails theOrderDetails) {
//    userDAO.saveOrderDetails(theOrderDetails);


}
