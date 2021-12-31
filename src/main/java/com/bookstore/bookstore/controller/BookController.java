package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.ServiceJPA.BookServiceJPA;
import com.bookstore.bookstore.ServiceJPA.OrderServiceJPA;
import com.bookstore.bookstore.ServiceJPA.UserServiceJPA;
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

    private final UserServiceJPA userService;
    @Autowired
    public BookController(BookServiceJPA bookService, OrderServiceJPA orderServiceJPA, UserServiceJPA userService) {
        this.bookService = bookService;
        this.orderServiceJPA = orderServiceJPA;
        this.userService = userService;
    }


    @GetMapping("/add")
    @Transactional
    public String addUser(Model model)
    {
       Book book=new Book();
        model.addAttribute("book",book);
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
//    @GetMapping("/listorders")
//    @Transactional
//    public String getOrders(Model model)
//    {
//        List<Order> list=bookService.get();
//        model.addAttribute("book",list);
//        return "books-list-for-user";
//    }

//    @Transactional
//    @PostMapping("/saveOrder")
//    public String saveOrder(@ModelAttribute("order") Order order,@RequestParam("book_id") int id,Model model) {
//        System.out.println("=============================================================");
//        System.out.println(order.getBook_id());
//        System.out.println(order.getUsername());
//      model.addAttribute("order",order);
//        bookService.saveOrder(order);
//        return "/home";
//    }
@PostMapping("/save")
@Transactional
public String saveBook(@ModelAttribute("book") Book book) {
    bookService.save(book);
    return "redirect:/book/list";
}

    @GetMapping("/find/{id}")
    @Transactional
    public String findBook(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books-list";
    }
   /* @PostMapping("/addbook")
    @Transactional
    public String addBook(Model theModel)
    {Book book=new Book();
        book.setId(0);
        theModel.addAttribute(book);
       return "add-book";
    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model, Principal presentUser)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("loggedUser",presentUser.getName());
            model.addAttribute("book",book);
            return "book-update";
        }
       bookService.saveBook(book);
        return "redirect/home";
    }

    */
   @GetMapping("/deleteGetId")
   public  String deleteBook(Model model)
   {
       Book book=new Book();

       model.addAttribute("book",book);
       return "delete-book-id";
   }
   @GetMapping("/updateGetId")
   public  String updateBook(Model model)
   {
       Book book=new Book();

       model.addAttribute("book",book);
       return "get-book-id";
   }
//    @PostMapping("/update")
//    @Transactional
//    public  String updateForm(@ModelAttribute("book") Book book,Model model)
//    {
//
//
//        Book theBook=bookService.getBook(book.getId());
//        model.addAttribute("book",theBook);
//        return "book-update";
//    }
    @PostMapping("/update")
    @Transactional
    public  String updateForm(@RequestParam("bookId") int id,Model model)
    {
        System.out.println("======================================");
        System.out.println("Id "+id);
  Book book=bookService.findById(id);
  model.addAttribute("book",book);
        return "book-update";
    }
    @PostMapping("/delete")
    @Transactional
    public  String deleteForm(@RequestParam("bookId") int id,Principal currentUser)
    {
        System.out.println("=======================================================");
        System.out.println(id);
       // userService.deleteOrderAdmin(currentUser.getName(), id);
       // System.out.println(id);

       orderServiceJPA.deleteByBookId(id);
        bookService.deleteById(id);
        return "redirect:/book/list";
    }
}
