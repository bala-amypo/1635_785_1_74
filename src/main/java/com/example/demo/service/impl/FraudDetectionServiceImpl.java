package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public void evaluateClaim(Claim claim) {
        // Simple logic: if amount > 10000, it's suspicious
        if (claim.getClaimAmount() != null && claim.getClaimAmount() > 10000) {
            claim.setStatus("FLAGGED");
        }
    }

    @Override
    public boolean checkClaim(Long claimId) {
        return claimRepository.findById(claimId)
                .map(claim -> "FLAGGED".equals(claim.getStatus()))
                .orElse(false);
    }
}