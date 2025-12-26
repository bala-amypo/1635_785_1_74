package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);

    User findById(Long id);

    // Required for test cases
    default User register(User user) {
        return registerUser(user);
    }
}
