package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;
import java.util.List;
public interface UserDAO {
    void save(User user);

    User getUser(String username);

    List<User> getAll();

   // List<OrderDetails> getOrderDetailss(String username);
   // OrderDetails getOrderDetails(String username);

    void saveRole(Authority theUser);
    List<OrderDetails> getOrderDetails(String username);
//    User getUser(int id);
//    void delete(int id);
//    List<User> getUsers();
//    List<OrderDetails> getOrderDetailss(String username);
    void saveOrderDetails(OrderDetails theOrderDetails);

    void deleteorder(String username, int id);

    boolean checkRes(String username, Long phone);

    void deleteOrderAdmin(String name, int id);
//    List<User> findAll();
}
