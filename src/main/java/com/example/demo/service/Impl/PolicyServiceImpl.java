package com.example.demo.service.impl;

import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUserId(Long userId) {
        return policyRepository.findByUserId(userId);
    }
}
