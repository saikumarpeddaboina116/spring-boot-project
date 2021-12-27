package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.inter.BookService;
import com.bookstore.bookstore.inter.OrderService;
import com.bookstore.bookstore.inter.UserService;
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
class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*  @GetMapping("/register")
    @Transactional
    public String addUser(Model theModel)
    {
        User theUser=new User();
        theUser.setId(0);

        theModel.addAttribute("user",theUser);
        return "user-add";
    }
*/
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
         List<User> list=userService.getAll();
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
       orderService.save(order);
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


        userService.save(theUser);
        userService.saveRole(auth);

        return "fancy-login";
    }
    @GetMapping("/find/{username}")
    @Transactional
    public String find(@PathVariable String username,Model model)
    {
        User user= userService.getUser(username);
        model.addAttribute("user",user);
        return "users-list";
    }
   @GetMapping("/ordersList")
   @Transactional
   public String getOrder( Principal currentUser,Model theModel) {
       System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
     String username=currentUser.getName();
//       System.out.println("In the Order List");
//       System.out.println(username);
     //List<OrderDetails> order=orderService.findAll();
       List<Book> bookList=new ArrayList<>();
       List<OrderDetails> orders=userService.getOrders(username);
       for(OrderDetails o:orders)
       {
           System.out.println("*******************************************");
           System.out.println(o.getBookId());

           bookList.add(bookService.getBook(o.getBookId()));
       }
       for(Book o:bookList)
       {
           System.out.println("5555555555555555555555555");
        //   System.out.println(o.getTitle());

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
   @GetMapping("/updateForgot")
   public  String updateForgot(String username,Model model)
   {
       System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       System.out.println(username);
       User user=userService.getUser(username);
       System.out.println("000000000000000000000000000000000000000000000");
       System.out.println(user.getUsername());
       System.out.println(user.getPhoneNumber());
       //user.setEnabled(1);
       model.addAttribute("user",user);
       return "user-update";
   }
@GetMapping("/update")
    public  String updateForm(Principal currentUser, Model model)
{
    System.out.println("999999999999999999999999999999999999999999");
    System.out.println(currentUser.getName());
    User user=userService.getUser(currentUser.getName());
  //user.setEnabled(1);
    model.addAttribute("user",user);
    return "user-update";
}
    @PostMapping("/deleteOrder")
    @Transactional
    public  String updateForm(@RequestParam("bookId") int id,Model model,Principal currentUser)
    {
        String username=currentUser.getName();
        userService.deleteOrder(username,id);
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
