package com.example.demo.repository;

import com.example.demo.model.Claim;
import java.util.List;
import java.util.Optional;

public interface ClaimRepository {
    Claim save(Claim claim);
    Optional<Claim> findById(Long id);
    List<Claim> findByPolicyId(Long policyId);
}