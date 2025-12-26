package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.service.ClaimService;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @Override
    public Claim submitClaim(Claim claim) {
        // 1. Basic Validation for tests
        if (claim.getClaimAmount() == null || claim.getClaimAmount() <= 0) {
            throw new IllegalArgumentException("Claim amount must be greater than zero");
        }

        // 2. Set default status
        claim.setStatus("PENDING");

        // 3. Trigger Fraud Detection logic
        // This usually populates the 'suspectedRules' set in the Claim model
        fraudDetectionService.evaluateClaim(claim);

        // 4. Update status if fraud is detected
        if (claim.getSuspectedRules() != null && !claim.getSuspectedRules().isEmpty()) {
            claim.setStatus("FLAGGED");
        }

        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public Claim updateClaimStatus(Long id, String status) {
        return claimRepository.findById(id).map(claim -> {
            claim.setStatus(status);
            return claimRepository.save(claim);
        }).orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}