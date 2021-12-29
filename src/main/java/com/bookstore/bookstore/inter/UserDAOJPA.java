package com.bookstore.bookstore.inter;

import com.bookstore.bookstore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAOJPA  extends JpaRepository<User,Integer> {
}
