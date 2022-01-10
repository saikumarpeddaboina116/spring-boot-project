package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Authority;
import com.bookstore.bookstore.repository.AuthorityDAORepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@SpringBootTest
class AuthorityServiceImplTest {
    @Autowired
    private AuthorityServiceJPA authorityServiceJPA;
    @MockBean
    private AuthorityDAORepo authorityDAORepo;


    @Test
    void save() {
        Authority auth = new Authority("Arjun", "ROLE_USER");
        authorityServiceJPA.save(auth);
        verify(authorityDAORepo, times(1)).save(auth);
    }
}