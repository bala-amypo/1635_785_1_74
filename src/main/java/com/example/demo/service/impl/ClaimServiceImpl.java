package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.HashSet;

@Service
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepo;
    private final PolicyRepository policyRepo;

    public ClaimServiceImpl(ClaimRepository cr, PolicyRepository pr) {
        this.claimRepo = cr;
        this.policyRepo = pr;
    }

    @Override
    public Claim createClaim(Long policyId, Claim claim) {
        // Test Requirement: testCreateClaimWithFutureDate
        if (claim.getClaimDate() != null && claim.getClaimDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future date");
        }
        
        // Test Requirement: testCreateClaimWithNegativeAmount
        if (claim.getClaimAmount() != null && claim.getClaimAmount() < 0) {
            throw new IllegalArgumentException("Negative amount");
        }
        
        Policy p = policyRepo.findById(policyId)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));
        
        claim.setPolicy(p);
        
        // Test Requirement: testEmptyManyToManySetIsValid
        if (claim.getSuspectedRules() == null) {
            claim.setSuspectedRules(new HashSet<>());
        }
        
        return claimRepo.save(claim);
    }

    @Override
    public Claim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}