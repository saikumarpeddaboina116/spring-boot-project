package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Authority;
import com.bookstore.bookstore.repository.AuthorityDAORepo;
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
