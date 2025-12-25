package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.registerUser(user); // Use existing method
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Use existing method
        User existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generate JWT token with id, email, role
            return jwtUtil.generateToken(existingUser.getId(), existingUser.getEmail(), existingUser.getRole());
        }

        return "Invalid credentials";
    }
}
