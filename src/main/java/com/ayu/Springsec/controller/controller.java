package com.ayu.Springsec.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping("/hi")
    public String greet(HttpServletRequest request) {
        return " welcome to my world  "+ request.getSession().getId();
    }
}
