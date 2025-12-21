package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        // If you want, you can add a method in UserService to get all users
        return null; // placeholder
    }
}
