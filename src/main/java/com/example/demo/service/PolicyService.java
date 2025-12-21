package com.example.demo.service;

import com.example.demo.model.Policy;

import java.util.List;

public interface PolicyService {
    Policy savePolicy(Policy policy);
    List<Policy> getPoliciesByUserId(Long userId);
}
