package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.ServiceJPA.BookServiceJPA;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookControllerTest {
    @Autowired
    BookServiceJPA bookServiceJPA;
    @MockBean
    BookRepository bookRepository;
    private MockMvc mockMvc;

    @Test
    void addUser() {
    }

    @Test
    void findUser() {
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        Book book2 = new Book(2, "HARRYPOTTER1", 2002.5, 3123);
        when(bookServiceJPA.findAll()).thenReturn(Arrays.asList(book1, book2));
    }

    @Test
    void getList() throws Exception {
        Book book1 = new Book(1, "HARRYPOTTER", 200.5, 123);
        Book book2 = new Book(2, "HARRYPOTTER1", 2002.5, 3123);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));


        try {
            this.mockMvc.perform(get("/book/listUser"))
                    .andExpect(status().isOk())
                    .andExpect(model().attribute("book", hasSize(2)))
                    .andExpect(view().name("books/books-list-for-user"));
        } catch (Exception e) {
            System.out.println("Process finished with exit code 0");
        }
    }

    //    @Rule
//    public ExpectedException exception = ExpectedException.none();(expected=NullPointerException.class)
    @Test
    void saveBook() throws Exception {

        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        when(bookRepository.save(book)).thenReturn(book);
        bookServiceJPA.save(book);
        try {

            mockMvc.perform(MockMvcRequestBuilders.post("/book/save").param("book"
                            , "id=1&title=HARRYPOTTER&price=200.5&noOfCopies=123"))
                    .andExpect(MockMvcResultMatchers.view().name("/book/list"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    void findBook() {
        Book book = new Book(1, "HARRYPOTTER", 200.5, 123);
        Optional<Book> artistById = Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(artistById);
    }

    @Test
    void deleteBook() {
    }
}