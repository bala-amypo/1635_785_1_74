package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private FraudRuleRepository fraudRuleRepository;

    @Autowired
    private FraudCheckResultRepository resultRepository;

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<FraudRule> rules = fraudRuleRepository.findAll();

        for (FraudRule rule : rules) {
            if (rule.getConditionField().equalsIgnoreCase("claimAmount")) {

                double threshold = Double.parseDouble(rule.getValue());

                if (claim.getClaimAmount() > threshold) {
                    FraudCheckResult result = new FraudCheckResult(
                            null,
                            claim,
                            true,
                            rule.getRuleName(),
                            "Claim amount exceeds threshold",
                            LocalDateTime.now()
                    );
                    return resultRepository.save(result);
                }
            }
        }

        FraudCheckResult result = new FraudCheckResult(
                null,
                claim,
                false,
                null,
                "No fraud detected",
                LocalDateTime.now()
        );

        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
