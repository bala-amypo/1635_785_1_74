package com.example.demo.service;
import com.example.demo.entity.User;

public interface UserService{
    User registerUser(User user);
    User findbyId(Long id);
    User findByEmail(String email);
}