package com.bookstore.bookstore.inter;


import com.bookstore.bookstore.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface  OrderDAORepo extends JpaRepository<OrderDetails,Integer> {
}
