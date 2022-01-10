package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class UserRepositoryTest {

    @MockBean
    private UserRepository userRepository;

    @Test
    @Order(2)
    @Rollback(value = false)
    void findById() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        String username = "arjun";
        Optional<User> user1 = userRepository.findById(username);
        verify(userRepository, times(1)).findById(username);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    void save() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        userRepository.save(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testFindById() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        String username = "arjun";
        Optional<User> user1 = userRepository.findById(username);
        verify(userRepository, times(1)).findById(username);

    }
}