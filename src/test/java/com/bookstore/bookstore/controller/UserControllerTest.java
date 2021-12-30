package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Repository.UserRepository;
import com.bookstore.bookstore.ServiceJPA.UserServiceJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserServiceJPA userServiceJPA;

    @Test
    void testAddUser() throws Exception {
      /*  this.mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user",hasProperty("username",is("arjun"))))
                .andExpect(view().name("user-add"));*/
    }


    @Test
    void testUpdateForm() {
    }


    @Test
    void testFindUser() {
    }

    @Test
    void testOrder() {
        User user1 = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        User user2 = new User("asai", "SaiArjun@123",
                1, "saik35arp612@gmail.com", 1234567891L);
        when(userServiceJPA.findAll()).thenReturn(Arrays.asList(user1, user2));
    }

    @Test
    void testSaveUser() throws Exception {
    /*    User user=new User("arjun","SaiArjun@123",
                1,"saikumarp612@gmail.com",1234567891L);
        System.out.println(user.getPhoneNumber());
        userServiceJPA.save(user);
       // userRepository.save(user);
        this.mockMvc.perform(post("/user/save")
                .param("username", "arjun")
                .param("password", "SaiArjun@123")
                .param("enabled", "1")
                .param("email", "saikumarp612@gmail.com")
                .param("phoneNumber", "1234567891L")
                        .sessionAttr("user",new User()))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/fancy-login"))
                .andExpect(redirectedUrl("/fancy-login"));
*/

    }

    @Test
    void testFind() {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        Optional<User> artistById = Optional.of(user);
        when(userRepository.findById("arjun")).thenReturn(artistById);

    }

    @Test
    void testGetOrder() {

    }

    @Test
    void testUpdateForm1() {
        User user = new User("arjun", "SaiArjun@123", 1,
                "saikumarp612@gmail.com", 1234567891L);
        Optional<User> artistById = Optional.of(user);
        when(userRepository.findById("arjun")).thenReturn(artistById);
    }

    @Test
    void testUpdateForm2() {
    }
}