package com.ayu.Springsec.controller;


import com.ayu.Springsec.model.UserModel;
import com.ayu.Springsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService service;

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user){

        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel user){

        return service.verify(user);
    }

}
