package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class BasicController {
    @Autowired
    private UserService userService;

    @GetMapping("/loginPage")
    public String login(Model theModel) {
        return "fancy-login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/access-denied")
    public String forgot(Model theModel) {
        return "access-denied";
    }














    @GetMapping("/forgot")
    public String accessDenied(Model theModel) {
        return "forgot-password";
    }
    @PostMapping("/check")
    public String check(@RequestParam("username") String username,@RequestParam("phone") Long phone,Model model)
    {
        boolean res=userService.checkRes(username,phone);
        if (res==false) {
            System.out.println("Wrong Username or phone");
            return "redirect:/loginPage";

        }
        else
        {
          //  UserController userController=new
           //         UserController();
          //  userController.updateForgot(username,model);
            return "redirect:/loginPage";
        }

    }


    @GetMapping("/setrole")
    public String updateRole(Principal currentUser, Model model,@ModelAttribute("user") User theUser) {
        String username= theUser.getUsername();
        System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
        String auth="ROLE_USER";
        Authority authority=new Authority();
        authority.setUsername(username);
        authority.setAuthority(auth);
        //String username=user.getUsername();
        //user.setEnabled(1);

        model.addAttribute("authority", authority);
        userService.saveRole(authority);
        return "redirect:/loginPage";
    }
    @PostMapping("/saverole")
    @Transactional
    public String saveUser(@ModelAttribute("authority") Authority theUser) {
        userService.saveRole(theUser);
        return "/home";
    }
}
