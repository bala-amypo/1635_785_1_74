package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudCheckResultRepository resultRepo;

    // MANDATORY: The test suite at line 57 requires this exact constructor
    public FraudDetectionServiceImpl(ClaimRepository claimRepo, FraudRuleRepository ruleRepo, 
                                    FraudCheckResultRepository resultRepo) {
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public void evaluateClaim(Claim claim) {
        if (claim.getClaimAmount() != null && claim.getClaimAmount() > 10000) {
            claim.setStatus("FLAGGED");
        }
    }

    @Override
    public boolean checkClaim(Long claimId) {
        return claimRepo.findById(claimId)
                .map(c -> "FLAGGED".equals(c.getStatus()))
                .orElse(false);
    }
}