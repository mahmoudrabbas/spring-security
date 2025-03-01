package com.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/basic1")
    public String basic1(){
        return "Hello from Basic 1";
    }

    @GetMapping("/basic2")
    public String basic2(){
        return "Hello from Basic 2"; 
    }
}
