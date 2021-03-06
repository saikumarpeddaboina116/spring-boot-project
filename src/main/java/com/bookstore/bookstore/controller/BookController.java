package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.convertor.BookConvertor;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookServiceJPA;
import com.bookstore.bookstore.service.OrderServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServiceJPA bookService;
    private final OrderServiceJPA orderServiceJPA;
    private BookConvertor bookConvertor;

    @Autowired
    public void booksConvertor(BookConvertor bookConvertor) {
        this.bookConvertor = bookConvertor;
    }

    @Autowired
    public BookController(BookServiceJPA bookService, OrderServiceJPA orderServiceJPA) {
        this.bookService = bookService;
        this.orderServiceJPA = orderServiceJPA;
    }

    @GetMapping("/add")
    @Transactional
    public String addUser(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book";
    }
    @GetMapping("/list")
    @Transactional
    public String findUser(Model model)
    {
        List<Book> list=bookService.findAll();
        model.addAttribute("book",list);
        return "books-list";
    }

    @Transactional
    @GetMapping("/listUser")
    public String getList(Model model) {
        List<Book> book = bookService.findAll();
        model.addAttribute("book", book);
        return "books/books-list-for-user";
    }

    @PostMapping("/save")
    @Transactional
    public String saveBook(@ModelAttribute("book") BookDTO book) {
        bookService.save(bookConvertor.dtoToEntity(book));
        return "redirect:/book/list";
    }

    @GetMapping("/find/{id}")
    @Transactional
    public String findBook(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books-list";
    }

    @PostMapping("/update")
    @Transactional
    public  String updateForm(@RequestParam("bookId") int id,Model model)
    {
  Book book=bookService.findById(id);
  model.addAttribute("book",book);
        return "book-update";
    }
    @PostMapping("/delete")
    @Transactional
    public  String deleteForm(@RequestParam("bookId") int id,Principal currentUser)
    {
        orderServiceJPA.deleteByBookId(id);
        bookService.deleteById(id);
        return "redirect:/book/list";
    }
}
