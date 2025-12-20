package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService{
    @Autowired UserRepository repo;
    @Autowired PasswordEncoder passwordEncoder;
    @Override
    public User re

}