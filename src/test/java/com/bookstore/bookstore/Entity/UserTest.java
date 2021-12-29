package com.bookstore.bookstore.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("Arjun");
        assertEquals("Arjun", user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("Sa@123");
        assertEquals("Sa@123", user.getPassword());
    }

    @Test
    void getEnabled() {
        User user = new User();
        user.setEnabled(1);
        assertEquals(1, user.getEnabled());
    }

    @Test
    void getEmail() {
        User user = new User();
        user.setEmail("saikumaro@gmail.com");
        assertEquals("saikumaro@gmail.com", user.getEmail());
    }

    @Test
    void getPhoneNumber() {
        User user = new User();
        user.setPhoneNumber(1234567895L);
        assertEquals(1234567895L, user.getPhoneNumber());
    }

    @Test
    void setUsername() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        user.setUsername("Arjun");
        assertEquals("Arjun", user.getUsername());
    }

    @Test
    void setPassword() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        user.setPassword("Sa@123");
        assertEquals("Sa@123", user.getPassword());
    }

    @Test
    void setEnabled() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        user.setEnabled(1);
        assertEquals(1, user.getEnabled());
    }

    @Test
    void setEmail() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        user.setEmail("saikumaro@gmail.com");
        assertEquals("saikumaro@gmail.com", user.getEmail());
    }

    @Test
    void setPhoneNumber() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        user.setPhoneNumber(1234567895L);
        assertEquals(1234567895L, user.getPhoneNumber());
    }
}