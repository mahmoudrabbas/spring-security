package com.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MainController {


    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/profile")
    public String getProfilePage(){
        return "profile";
    }

    @GetMapping("/manager")
    public String getManagerPage(){
        return "manager";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/client")
    public String getClientPage(){
        return "client";
    }

    @GetMapping("/client2")
    public String getClient2Page(){
        return "client2";
    }
}

