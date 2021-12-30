package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Exception.MyException;
import com.bookstore.bookstore.ServiceJPA.AuthorityServiceJPA;
import com.bookstore.bookstore.ServiceJPA.UserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        return "home-page";
    }

    @GetMapping("/error")
    public String error() {
        return "error-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        throw new MyException("Access Denied");
    }

















}
