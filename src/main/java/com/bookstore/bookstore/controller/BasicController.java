package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Entity.Authority;
import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Exception.MyException;
import com.bookstore.bookstore.ServiceJPA.AuthorityServiceJPA;
import com.bookstore.bookstore.ServiceJPA.UserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BasicController {
    @Autowired
    private UserServiceJPA userService;
    @Autowired
    private AuthorityServiceJPA authorityServiceJPA;

    @GetMapping("/loginPage")
    public String login(Model theModel) {
        return "fancy-login";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @GetMapping("/error")
    public String error() {
        return "error-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        throw new MyException("Access Denied");
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
        authorityServiceJPA.save(authority);
        return "redirect:/loginPage";
    }
    @PostMapping("/saverole")
    @Transactional
    public String saveUser(@ModelAttribute("authority") Authority theUser) {
        authorityServiceJPA.save(theUser);
        return "/home";
    }
}
