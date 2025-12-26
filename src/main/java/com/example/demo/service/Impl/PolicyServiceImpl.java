package com.example.demo.service.impl;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    private final PolicyRepository policyRepo;
    private final UserRepository userRepo;

    public PolicyServiceImpl(PolicyRepository pr, UserRepository ur) {
        this.policyRepo = pr;
        this.userRepo = ur;
    }

    public Policy createPolicy(Long userId, Policy policy) {
        if (policy.getEndDate().isBefore(policy.getStartDate())) {
            throw new IllegalArgumentException("Invalid dates");
        }
        if (policyRepo.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Policy number already exists");
        }
        User user = userRepo.findById(userId).orElseThrow();
        policy.setUser(user);
        return policyRepo.save(policy);
    }

    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepo.findByUserId(userId);
    }
}