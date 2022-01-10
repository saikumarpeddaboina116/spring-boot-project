package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.repository.AuthorityDAORepo;
import com.bookstore.bookstore.service.AuthorityServiceJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class BasicControllerTest {
    BasicController basicController;
    private MockMvc mockMvc;
    @Autowired
    private AuthorityServiceJPA authorityServiceJPA;
    @MockBean
    private AuthorityDAORepo authorityDAORepo;

    @BeforeEach
    public void setup() {
        basicController = new BasicController();
        mockMvc = MockMvcBuilders.standaloneSetup(basicController).build();
    }

    @Test
    void contextLoads() {
        assertThat(basicController).isNotNull();
    }

    @Test
    void loginPageTest() throws Exception {
        mockMvc.perform(get("/loginPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("fancy-login"));
    }

    @Test
    void accessDeniedPageTest() {
        Exception exception = assertThrows(NestedServletException.class, () -> mockMvc.perform(get("/access-denied"))
                .andExpect(status().isNotFound()));
        String expectedMessage = "Request processing failed; nested exception is com.bookstore.bookstore.exception.MyException: Access Denied";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void homePageTest() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home-page"));
    }

    @Test
    void errorPageTest() throws Exception {
        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(view().name("error-page"));
    }


}