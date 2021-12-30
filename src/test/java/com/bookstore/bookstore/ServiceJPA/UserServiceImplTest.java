package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Exception.MyException;
import com.bookstore.bookstore.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceJPA userServiceJPA;
    @MockBean
    UserRepository userRepository;

    @Test
    void save() {
        User user=new User("arjun","SaiArjun@123",1,"saikumarp612@gmail.com",1234567891L);
        userServiceJPA.save(user);
        verify(userRepository,times(1)).save(user);
    }



    @Test
    void findAll() {
        when(userRepository.findAll()).thenReturn(Stream.of(
                new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L),
                new User("asai", "SaiArjun@123", 1, "saik35arp612@gmail.com", 1234567891L)
        ).collect(Collectors.toList()));
        assertEquals(2, userServiceJPA.findAll().size());
    }

    @Test
    void findById() {
        User user = new User("arjun", "SaiArjun@123", 1, "saikumarp612@gmail.com", 1234567891L);
        Optional<User> userById = Optional.of(user);
        when(userRepository.findById("arjun")).thenReturn(userById);
        assertEquals(userServiceJPA.findById("arjun"), user);
    }

    @Test
    void findById_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> userServiceJPA.findById("arjun"));
        String expectedMessage = "Did not find Book with id - arjun";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}