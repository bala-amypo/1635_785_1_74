package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    // Manual constructor required by the test suite
    public ClaimServiceImpl(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Claim createClaim(Long policyId, Claim claim) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        claim.setPolicy(policy);
        claim.setStatus("PENDING");
        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getClaim(Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    @Override
    public Claim updateClaimStatus(Long id, String status) {
        Claim claim = claimRepository.findById(id).orElseThrow();
        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}