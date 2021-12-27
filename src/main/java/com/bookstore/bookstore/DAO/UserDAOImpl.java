package com.bookstore.bookstore.DAO;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.inter.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        User theUser = entityManager.merge(user);

      //currSession.save(user);

    }
  /*  @Autowired
    private EntityManager entityManager;
    @Override
    public void saveUser(User user) {
      User theUser = entityManager.merge(user);
       user.setUsername(theUser.getUsername());

    }
*/

    @Override
    public User getUser(String name) {
        User user = entityManager.createQuery("from User where username= :name", User.class).setParameter("name",name).getSingleResult();
        return user;
    }

    @Override
    public List<User> getAll() {
       List<User> user = entityManager.createQuery("from User ", User.class).getResultList();
        return user;
    }
//    @Override
//    public OrderDetails getOrderDetails(String name) {
//       OrderDetails OrderDetailss = entityManager.createQuery("from OrderDetails where username= :name ", OrderDetails.class).setParameter("name",name).getSingleResult();
//        return OrderDetailss;
//    }

    @Override
    public void saveRole(Authority theUser) {
        System.out.println(theUser.getAuthority());
        System.out.println(theUser.getUsername());
        Authority authority=entityManager.merge(theUser);
    }

    @Override
    public List<OrderDetails> getOrderDetails(String username) {
        System.out.println("???????????????????????????//////////////////////");
        System.out.println(username);
       List<OrderDetails> orderDetails= entityManager.createQuery("from OrderDetails where username= :name")
               .setParameter("name",username).getResultList();
     for(OrderDetails o:orderDetails)
     {
         System.out.println(o.getBookId());
         System.out.println(o.getUsername());
     }
        return orderDetails;
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails) {
       OrderDetails orderDetails= entityManager.merge(theOrderDetails);
    }

    @Override
    public void deleteorder(String username, int id) {
        System.out.println("1111111111111111111111111111111111111111");
        System.out.println(username+"  "+id);
        OrderDetails orderDetails;
//        entityManager.createQuery("delete from OrderDetails where username= :name and bookId= :id limit 1")
//                .setParameter("name",username);
        Query theQuery=  entityManager.createQuery("delete from OrderDetails where username= :name and bookId= :id")
                .setParameter("name",username)
                .setParameter("id",id);
                theQuery.executeUpdate();
    }

    @Override
    public boolean checkRes(String username, Long phone) {
        List<User> user=entityManager.createQuery("from User where username= :user and phoneNumber= :phone")
                .setParameter("user",username)
                .setParameter("phone",phone)
                .getResultList();
        System.out.println(user);
        if(user.size() == 0)
        return false;
        else
            return true;
    }

    @Override
    public void deleteOrderAdmin(String name, int id) {
        System.out.println(name);
        System.out.println(id);
        Query theQuery=  entityManager.createQuery("delete from OrderDetails where bookId= :id ")
                .setParameter("id",id);
        theQuery.executeUpdate();

    }



/*

    //     createQuery("from User where User.username=:name");
   /*     query.setParameter("name",name);
        System.out.println(name);
       List<User> user= query.getResultList();

        System.out.println(user.toString());
        return user.get(0);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getUsers() {
        List<User> list=entityManager.createQuery("from User", User.class).getResultList();
        return list;
    }

    @Override
    public List<OrderDetails> getOrderDetailss(String username) {
        List<OrderDetails> OrderDetails=entityManager.createQuery("from OrderDetails where username:=username",OrderDetails.class).getResultList();
        return OrderDetails;
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails) {
OrderDetails OrderDetails=entityManager.merge(theOrderDetails);

    }*/
//@Override
//public void saveOrderDetails(OrderDetails theOrderDetails) {
//    User user= (User) entityManager.createQuery("from User where username= :name").setParameter("name",theOrderDetails.getUsername())
//            .getSingleResult();
//    Book book= (Book) entityManager.createQuery("from Book where id= :id").setParameter("id",theOrderDetails.getBook_id()).getSingleResult();
//    user.addBook(book);
//    book.addUser(user);
//    entityManager.merge(book);
//    entityManager.merge(user);
//
//
//
//}

}
