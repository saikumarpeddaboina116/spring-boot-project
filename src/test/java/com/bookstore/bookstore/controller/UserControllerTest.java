package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderDetails;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.repository.UserRepository;
import com.bookstore.bookstore.service.OrderServiceJPA;
import com.bookstore.bookstore.service.UserServiceJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
//@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    OrderServiceJPA orderServiceJPA;
    @MockBean
    private UserServiceJPA userServiceJPA;

    @Test
    void testAddUser() throws Exception {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        when(userServiceJPA.findById("arjun")).thenReturn(user);
        mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-add"));
    }
    @Test
    void findUser() throws Exception {
        User user2 = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        User user1 = new User("sai", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567981L);
        when(userServiceJPA.findAll()).thenReturn(Arrays.asList(user2, user1));
        //   assertEquals(2, bookServiceJPA.findAll().size());
        this.mockMvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", hasSize(2)))
                .andExpect(view().name("users-list"));
    }

    @Test
    void saveUser() throws Exception {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        userServiceJPA.save(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save").param("username", "arjun")

                        .param("password", "SaiArjun@123"))
//                .param("enabled","1")
//                .param("email","saikumarp612@gmail.com")
//                .param("phoneNumber","1234567891L"))
                // .andExpect(model().attribute("user", hasProperty())
                .andExpect(MockMvcResultMatchers.view().name("fancy-login"));
    }
    @Test
    void find() throws Exception {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        //  userServiceJPA.save(user);
        when(userServiceJPA.findById("arjun")).thenReturn(user);
        mockMvc.perform(get("/user/find/'arjun'"))
                .andExpect(status().isOk())
                .andExpect(view().name("users-list"));
    }

    @Test
    void testDeleteOrder() throws Exception {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        OrderDetails orderDetails = new OrderDetails(1, 1, "arjun");
        orderServiceJPA.save(orderDetails);
        orderServiceJPA.deleteByUsername("arjun", 1);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/deleteOrder")
                        .param("bookId", "1"))
                .andExpect(MockMvcResultMatchers.view().name("error-page"));
    }



}
