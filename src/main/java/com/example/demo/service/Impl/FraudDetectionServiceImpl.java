package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudCheckResultRepository resultRepo;

    public FraudDetectionServiceImpl(
            ClaimRepository claimRepo,
            FraudRuleRepository ruleRepo,
            FraudCheckResultRepository resultRepo) {
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setCheckedAt(LocalDateTime.now());
        result.setIsFraudulent(false);

        return resultRepo.save(result);
    }

    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepo.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
