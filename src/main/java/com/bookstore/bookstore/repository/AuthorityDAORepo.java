package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDAORepo extends JpaRepository<Authority,String> {

}
