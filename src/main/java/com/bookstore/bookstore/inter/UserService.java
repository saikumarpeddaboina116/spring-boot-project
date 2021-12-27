package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.Authority;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;


import java.util.List;

public interface UserService {
 public  void save(User user);

User getUser(String username);

 List<User> getAll();
// Order getOrder(String username);
// List<Order> getOrders(String username);

 //Order getOrder(String username);

 void saveRole(Authority theUser);

 List<OrderDetails> getOrders(String username);
 //  void delete(int id);
  // public List<User> findAll();
//List<Order> getOrders(String username);

    void saveOrder(OrderDetails theOrder);

    void deleteOrder(String username, int id);

    boolean checkRes(String username, Long phone);

    void deleteOrderAdmin(String name, int id);

    //  List<Order> getOrders();



}
