package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.ServiceJPA.BookServiceJPA;
import com.bookstore.bookstore.ServiceJPA.OrderServiceJPA;
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
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false)
class BookControllerTest {
    @MockBean
    BookServiceJPA bookServiceJPA;
    @MockBean
    BookRepository bookRepository;
    @MockBean
    OrderServiceJPA orderServiceJPA;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveBook() throws Exception {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        mockMvc.perform(MockMvcRequestBuilders.post("/book/save").param("book"
                        , "id=1&title=HARRYPOTTER&price=200.5&noOfCopies=123"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/book/list"));
    }

    @Test
    void addUser() throws Exception {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        when(bookServiceJPA.findById(1)).thenReturn(book);
        mockMvc.perform(get("/book/add"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("book", hasProperty("id", is(0))))
                .andExpect(view().name("add-book"));
    }

    @Test
    void findUser() throws Exception {
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        Book book2 = new Book(2, "HARRYPOTTER1", 2002.5, 3123);
        when(bookServiceJPA.findAll()).thenReturn(Arrays.asList(book1, book2));
        //   assertEquals(2, bookServiceJPA.findAll().size());
        this.mockMvc.perform(get("/book/list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("book", hasSize(2)))
                .andExpect(view().name("books-list"));
    }

    @Test
    void getList() throws Exception {
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        Book book2 = new Book(2, "HARRYPOTTER1", 2002.5, 3123);
        when(bookServiceJPA.findAll()).thenReturn(Arrays.asList(book1, book2));
        this.mockMvc.perform(get("/book/listUser"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("book", hasSize(2)))
                .andExpect(view().name("books/books-list-for-user"));

    }

    @Test
    void findBook() throws Exception {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        Optional<Book> artistById = Optional.of(book);
        when(bookServiceJPA.findById(1)).thenReturn(book);
        mockMvc.perform(get("/book/find/1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("book", hasProperty("title", is("HARRYPOTTER"))))
                .andExpect(view().name("books-list"));

    }

    @Test
    void deleteBook() throws Exception {
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        orderServiceJPA.deleteByBookId(1);
        bookServiceJPA.save(book1);
        bookServiceJPA.deleteById(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/book/delete").param("bookId", "1"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/book/list"));
    }

    @Test
    void updateTest() throws Exception {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        bookServiceJPA.findById(1);
/*    mockMvc.perform(MockMvcRequestBuilders.post("/book/update").param("bookId","1"))
            .andExpect(model().attribute("book",hasProperty("id",is(1))))
            .andExpect(MockMvcResultMatchers.view().name("book-update"));*/
    }


}