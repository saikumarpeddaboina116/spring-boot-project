package com.bookstore.bookstore.Controller;

import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.controller.UserController;
import com.bookstore.bookstore.inter.*;
import com.bookstore.bookstore.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class UsersControllerTest {
    private MockMvc mockMvc;

    UsersControllerTest usersControllerTest;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private OrderDAORepo orderDAORepo;


    @BeforeEach
    void setup() {
        UserController userController = new UserController(userService,orderService,bookService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @Rollback(false)
    public void testCreateOrder() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setUsername("Zemoso");
        orderDetails.setId(1);
        orderDetails.setBookId(10);
        orderService.save(orderDetails);
        assertThat(orderDetails.getId()).isGreaterThan(0);
    }

    /*@Test
    public void testListProducts() {
        List<OrderDetails> products = orderService.findAll();
        assertThat(products.size()).isGreaterThan(0);
    }
    @Test
    void contextLoads()
    {
        assertThat(usersControllerTest).isNotNull();
    }*/
  /*  @Test
    @Rollback(false)
    void showFormForAddItem() throws Exception {
User user=null;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("user",user))
                .andExpect(view().name("/users-add"));
    }*/
 /*   @Test
    void save_addUser() throws Exception {

        this.mockMvc.perform(post("/user/save")
                        .param("username", "Zemoso")
                        .param("password", "abcdef@12345")
                        .param("enabled", String.valueOf(1))
                        .param("email", "saikumarp128uqi@gmail.com")
                        .sessionAttr("user", new User()))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("fancy-login"));

    }*/

    @Test
    void saveNewUser() throws Exception {
        User users = null;

        this.mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("users", users))
                .andExpect(view().name("user-add"));
//        this.mockMvc.perform(post("/user/save")
//                        .param("username", "jack@artist.com")
//                        .param("password", "abcdef@12345")
//                        .param("enabled", String.valueOf(1))
//                        .param("email","saikumarp128uqi@gmail.com")
//                        .sessionAttr("user", new UserServiceImpl()))
//                .andExpect(status().isMovedTemporarily())
//                .andExpect(view().name("redirect:/loginPage"))
//                .andExpect(redirectedUrl("/loginPage"));
      /*  User user=new User();
        user.setUsername("Zemoso");
        user.setPassword("Adbshxb@123");
        user.setPhoneNumber(1234567890L);
        user.setEmail("saikumarp128uqi@gmail.com");
        user.setEnabled(1);

        UserController userController=new UserController();
        Model model= (Model) user;
        model.addAttribute("user",user);
    String res=userController.addUser(model);
        assertEquals( res, "user-add");
    //    assertNotNull(userDAO.getUser("Zemoso").getUsername());
        /*mockMvc.perform(post("/user/save").param("user","username=Zemoso&password=Adbshxb@123&enabled=1&email=saikumarp128uqi@gmail.com&phoneNumber=1234567890L"))
                .andExpect(view().name("fancy-login"));*/
     /*   User user=new User();
        given(user.getUsername()).willReturn("Username");
        given(user.getPassword()).willReturn("Password");
        given(user.getEnabled()).willReturn(1);
        given(user.getEmail()).willReturn("aikumarp128uqi@gmail.com");
        User users=new User();
        given(userService.save(any(User.class))).willReturn(user);
        boolean res=userService.save(user);
        then(userService).should(times(1)).save(any(User.class));
        assertEquals(true, res);*/
    }
}


