package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired UserService service;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.registerUser(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return service.loginUser(user.getEmail(),user.getPassword());
    }
}