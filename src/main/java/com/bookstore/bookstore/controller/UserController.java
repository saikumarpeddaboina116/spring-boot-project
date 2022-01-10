package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.convertor.UserConvertor;
import com.bookstore.bookstore.dto.UserDTO;
import com.bookstore.bookstore.entity.Authority;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderDetails;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.service.AuthorityServiceJPA;
import com.bookstore.bookstore.service.BookServiceJPA;
import com.bookstore.bookstore.service.OrderServiceJPA;
import com.bookstore.bookstore.service.UserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public
class UserController {
    private final AuthorityServiceJPA authorityServiceJPA;
    private final OrderServiceJPA orderServiceJPA;

    private final BookServiceJPA bookServiceJPA;

    private final UserServiceJPA userServiceJPA;
    private UserConvertor userConvertor;

    @Autowired
    public void booksConvertor(UserConvertor userConvertor) {
        this.userConvertor = userConvertor;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(AuthorityServiceJPA authorityServiceJPA, OrderServiceJPA orderService,
                          BookServiceJPA bookServiceJPA, UserServiceJPA userServiceJPA) {
        this.authorityServiceJPA = authorityServiceJPA;
        this.orderServiceJPA = orderService;
        this.bookServiceJPA = bookServiceJPA;
        this.userServiceJPA = userServiceJPA;
    }

    @GetMapping("/add")
  @Transactional
  public String addUser(Model model)
  {
      User user=new User();
      model.addAttribute("user",user);
      return "user-add";
  }


   @GetMapping("/list")
    @Transactional
    public String findUser(Model model)
    {
         List<User> list=userServiceJPA.findAll();
         model.addAttribute("user",list);
         return "users-list";
    }

    @PostMapping("/order")
    @Transactional
    public String order(@RequestParam("bookId") int id,Principal currentUser,Model model) {
        String username = currentUser.getName();
        OrderDetails order = new OrderDetails();
        order.setBookId(id);
        order.setUsername(username);
        model.addAttribute("order", order);
        orderServiceJPA.save(order);
        return "redirect:/user/ordersList";
    }

    @PostMapping("/save")
    @Transactional
    public String saveUser(@ModelAttribute("user") UserDTO theUser, Model model, Principal currentUser
            , @RequestParam("username") String username) {
        String encodedPassword = bCryptPasswordEncoder.encode(theUser.getPassword());
        theUser.setPassword(encodedPassword);
        theUser.setEnabled(1);
        model.addAttribute("user", theUser);
        String authority = "ROLE_USER";
        Authority auth = new Authority();
        auth.setAuth(authority);
        auth.setUsername(username);
        userServiceJPA.save(userConvertor.dtoToEntity(theUser));
        authorityServiceJPA.save(auth);

        return "fancy-login";
    }
    @GetMapping("/find/{username}")
    @Transactional
    public String find(@PathVariable String username,Model model)
    {
        User user= userServiceJPA.findById(username);
        model.addAttribute("user",user);
        return "users-list";
    }
   @GetMapping("/ordersList")
   @Transactional
   public String getOrder( Principal currentUser,Model theModel) {
     String username=currentUser.getName();
       List<Book> bookList=new ArrayList<>();
       List<OrderDetails> orders=orderServiceJPA.findByUsername(username);
       for(OrderDetails o:orders)
       {
        bookList.add(bookServiceJPA.findById(o.getBookId()));
       }
      theModel.addAttribute("book",bookList);
       return "order-list";
   }


    @GetMapping("/update")
    public String updateForm(Principal currentUser, Model model) {
        User user = userServiceJPA.findById(currentUser.getName());
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/deleteOrder")
    @Transactional
    public String deleteOrder(@RequestParam("bookId") int id, Principal currentUser) {
        String username = currentUser.getName();
        orderServiceJPA.deleteByUsername(username, id);
        return "redirect:/user/ordersList";
    }

}
