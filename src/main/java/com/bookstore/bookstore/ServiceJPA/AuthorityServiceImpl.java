package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Repository.AuthorityDAORepo;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityServiceJPA{
    private final AuthorityDAORepo authorityDAORepo;

    public AuthorityServiceImpl(AuthorityDAORepo authorityDAORepo) {
        this.authorityDAORepo = authorityDAORepo;
    }

    @Override
    public void save(Authority authority) {
        authorityDAORepo.save(authority);
    }
}
