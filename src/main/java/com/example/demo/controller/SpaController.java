package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5174", allowCredentials = "true")
public class SpaController {

    @RequestMapping(value = {
        "/",
        "/register",
        "/login", 
        "/customerhome",
        "/adminhome",
        "/user/**",
        "/admin/**",
        "/{path:[^\\.]*}"         
    })
    public String forwardToReact() {
        return "forward:/index.html";
    }
}
