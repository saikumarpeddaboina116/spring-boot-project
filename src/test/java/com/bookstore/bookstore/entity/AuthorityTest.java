package com.bookstore.bookstore.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorityTest {

    @Test
    void getUsername() {
        Authority authority = new Authority();
        authority.setUsername("arjun");
        assertEquals("arjun", authority.getUsername());
    }

    @Test
    void getAuthority() {
        Authority authority = new Authority();
        authority.setAuth("ROLE_USER");
        assertEquals("ROLE_USER", authority.getAuth());
    }

    @Test
    void setUsername() {
        Authority authority = new Authority();
        authority.setUsername("arjun");
        assertEquals("arjun", authority.getUsername());
    }

    @Test
    void setAuthority() {
        Authority authority = new Authority();
        authority.setAuth("ROLE_USER");
        assertEquals("ROLE_USER", authority.getAuth());
    }
}