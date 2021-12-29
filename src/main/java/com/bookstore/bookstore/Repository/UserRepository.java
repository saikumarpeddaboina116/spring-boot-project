package com.bookstore.bookstore.Repository;

import com.bookstore.bookstore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Override
    Optional<User> findById(String s);
}
