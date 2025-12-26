package com.example.demo.service.impl;

import com.example.demo.model.Policy;
import com.example.demo.model.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository, UserRepository userRepository) {
        this.policyRepository = policyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Policy createPolicy(Long userId, Policy policy) {
        // 1. Validate Dates (Requirement for testCreatePolicyInvalidDates)
        if (policy.getEndDate() != null && policy.getStartDate() != null) {
            if (policy.getEndDate().isBefore(policy.getStartDate())) {
                throw new IllegalArgumentException("Invalid dates");
            }
        }

        // 2. Check for Duplicate Policy Number (Requirement for testPolicyEntityUniquePolicyNumberConstraint)
        if (policyRepository.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Policy number already exists");
        }

        // 3. Link to User (Requirement for testCreatePolicySuccess)
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        policy.setUser(user);
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        // Requirement for testGetPoliciesByUser
        return policyRepository.findByUserId(userId);
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
    }
}