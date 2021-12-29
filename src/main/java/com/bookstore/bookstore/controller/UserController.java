package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.ServiceJPA.AuthorityServiceJPA;
import com.bookstore.bookstore.ServiceJPA.BookServiceJPA;
import com.bookstore.bookstore.ServiceJPA.OrderServiceJPA;

import com.bookstore.bookstore.ServiceJPA.UserServiceJPA;
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

    private  final BookServiceJPA bookServiceJPA;

    private final UserServiceJPA userServiceJPA;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserController(AuthorityServiceJPA authorityServiceJPA, OrderServiceJPA orderService,
                          BookServiceJPA bookServiceJPA, UserServiceJPA userServiceJPA)
    {
        this.authorityServiceJPA = authorityServiceJPA;
        this.orderServiceJPA=orderService;
        this.bookServiceJPA = bookServiceJPA;
        this.userServiceJPA=userServiceJPA;
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
        String username=currentUser.getName();
        OrderDetails order=new OrderDetails();
        order.setBookId(id);
        System.out.println("----------------------------------------------------------");
        System.out.println(username);
        System.out.println(id);
        order.setUsername(username);
        model.addAttribute("order",order);
        orderServiceJPA.save(order);
        return "redirect:/user/ordersList";
    }
    @PostMapping("/save")
    @Transactional
    public String saveUser(@ModelAttribute("user") User theUser,Model model,Principal currentUser
            ,@RequestParam("username") String username) {
        String encodedPassword = bCryptPasswordEncoder.encode(theUser.getPassword());
        theUser.setPassword(encodedPassword);
        theUser.setEnabled(1);
        model.addAttribute("user",theUser);
        System.out.println("_____________________________________________");
        System.out.println(username);
        String authority="ROLE_USER";
        Authority auth=new Authority();
        auth.setAuthority(authority);
        auth.setUsername(username);
        userServiceJPA.save(theUser);
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
       System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
     String username=currentUser.getName();
       System.out.println(username);
//       System.out.println("In the Order List");
//       System.out.println(username);
     //List<OrderDetails> order=orderService.findAll();
       List<Book> bookList=new ArrayList<>();
       List<OrderDetails> orders=orderServiceJPA.findByUsername(username);
       for(OrderDetails o:orders)
       {
           System.out.println("*******************************************");
           System.out.println(o.getUsername());
           System.out.println(o.getBookId());

           bookList.add(bookServiceJPA.findById(o.getBookId()));
       }
       for(Book o:bookList)
       {
           System.out.println("5555555555555555555555555");
         System.out.println(o.getTitle());

       //    bookList.add(bookService.getBook(o.getBookId()));
       }

       System.out.println(orders.toString());
      theModel.addAttribute("book",bookList);


       return "order-list";
   }
   /*  List<Order> result=userService.getOrders(username);
        theModel.addAttribute("orders",result);*/
      //  return "order-list";
 /*  }
   @GetMapping("/order")
    public String saveOrder(Model model)
   {
       Order order=new Order();
       model.addAttribute("order",order);
       return "order";
   }
   @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order theOrder)
    {
        userService.saveOrder(theOrder);
        return "redirect/user/order-list";
    }
    */

@GetMapping("/update")
    public  String updateForm(Principal currentUser, Model model)
{
    System.out.println("999999999999999999999999999999999999999999");
    System.out.println(currentUser.getName());
    User user=userServiceJPA.findById(currentUser.getName());
  //user.setEnabled(1);
    model.addAttribute("user",user);
    return "user-update";
}
    @PostMapping("/deleteOrder")
    @Transactional
    public  String updateForm(@RequestParam("bookId") int id,Principal currentUser)
    {
        String username=currentUser.getName();
        System.out.println(id);
        orderServiceJPA.deleteByUsername(username,id);
        System.out.println("======================================");
        System.out.println(username+" "+ id);

        return "redirect:/user/ordersList";
    }/*
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser)
    {
        userService.save(theUser);
        return "redirect/user/home";
    }*/

}
