package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Signup endpoint
    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody AuthRequest request) {
        User existingUser = userService.findByEmail(request.getEmail());
        if (existingUser != null) {
            return new AuthResponse("User already exists", false);
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain password for simplicity
        userService.saveUser(user);

        return new AuthResponse("User registered successfully", true);
    }

    // Login endpoint
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null) {
            return new AuthResponse("User not found", false);
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new AuthResponse("Incorrect password", false);
        }

        return new AuthResponse("Login successful", true);
    }
}
