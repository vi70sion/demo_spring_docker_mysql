package com.example.demo_spring_linux.controller;

import com.example.demo_spring_linux.model.User;
import com.example.demo_spring_linux.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService = new UserService();

    @CrossOrigin
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }



}
