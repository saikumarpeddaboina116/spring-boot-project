package com.bookstore.bookstore.Controller;



import com.bookstore.bookstore.controller.BasicController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class BasicControllerTest {
    private MockMvc mockMvc;

    BasicController basicController;
    @BeforeEach
    public void setup()
    {
        basicController = new BasicController();
        mockMvc= MockMvcBuilders.standaloneSetup(basicController).build();
    }
    void contextLoads()
    {
        assertThat(basicController).isNotNull();
    }

    @Test
    void loginPageTest() throws Exception {
        mockMvc.perform(get("/loginPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("/fancy-login"));
    }
    @Test
    void accessDeniedTest() throws Exception {
        mockMvc.perform(get("/access-denied"))
                .andExpect(status().isOk())
                .andExpect(view().name("access-denied"));
    }
    @Test
    void homeTest() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

}
