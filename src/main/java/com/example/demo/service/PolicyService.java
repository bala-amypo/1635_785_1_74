package com.example.demo.service;
import com.example.demo.model.Policy;
import java.util.List;

public interface UserService{
    Policy createPolicy(Long userId,Policy policy);
    List<Policy> getPolicyByUser(Long userId);
    Policy getPolicy(Long id);
}