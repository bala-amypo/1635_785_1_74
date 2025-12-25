package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthController(UserService service, PasswordEncoder encoder, JwtUtil jwt) {
        this.service = service;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public User register(@RequestBody AuthRequest req) {
        return service.registerUser(
                new User(null, req.getName(), req.getEmail(), req.getPassword(), null, null));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        User user = service.findByEmail(req.getEmail());
        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new IllegalArgumentException("Invalid credentials");

        return new AuthResponse(
                jwt.generateToken(user.getId(), user.getEmail(), user.getRole()),
                user.getId(),
                user.getEmail(),
                user.getRole());
    }
}
