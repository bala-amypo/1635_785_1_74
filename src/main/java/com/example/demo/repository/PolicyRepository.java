package com.example.demo.repository;

import com.example.demo.model.Policy;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository {
    boolean existsByPolicyNumber(String policyNumber);
    Policy save(Policy policy);
    Optional<Policy> findById(Long id);
    List<Policy> findByUserId(Long userId);
    long count();
}