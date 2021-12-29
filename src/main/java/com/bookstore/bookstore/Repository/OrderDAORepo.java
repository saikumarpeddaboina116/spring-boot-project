package com.bookstore.bookstore.Repository;


import com.bookstore.bookstore.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface  OrderDAORepo extends JpaRepository<OrderDetails,Integer> {
    List<OrderDetails> findByUsername(String username);

    @Modifying
    @Query("delete from OrderDetails where username= :name and bookId= :id")
    void deleteByUsername(@Param("name") String username,@Param("id") int id);

    @Modifying
    @Query("delete from OrderDetails where bookId= :id")
    void deleteByBookId(@Param("id") int id);



}
