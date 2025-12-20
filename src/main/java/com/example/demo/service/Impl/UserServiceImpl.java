package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService{
    @Autowired UserRepository repo;
    @Autowired PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(User user){
        if(repo.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Invalid or duplicate email");
        }
    
    if(user.getRole()==null){
        user.setRole("USER");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return repo.save(user);
    }
    @Override
    public User findById(Long id){
        return repo.findById(id).orElseThrow(()->new ResourceNotFound("User not found"));
    }
    @Override
    public User findByEmail(String email){
        return repo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }
}