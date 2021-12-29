package com.bookstore.bookstore.Repository;

import com.bookstore.bookstore.Entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDAORepo extends JpaRepository<Authority,String> {

}
