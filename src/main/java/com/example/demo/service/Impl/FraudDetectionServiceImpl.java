package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.repository.FraudRuleRepository;
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

            if (rule.getConditionField().equals("claimAmount")) {

                double threshold = Double.parseDouble(rule.getValue());

                if (rule.getOperator().equals(">") &&
                        claim.getClaimAmount() > threshold) {

                    FraudCheckResult result = new FraudCheckResult();
                    result.setClaim(claim);
                    result.setIsFraudulent(true);
                    result.setTriggeredRuleName(rule.getRuleName());
                    result.setRejectionReason("Claim amount exceeds allowed limit");
                    result.setCheckedAt(LocalDateTime.now());

                    return resultRepository.save(result);
                }
            }
        }

        FraudCheckResult safeResult = new FraudCheckResult();
        safeResult.setClaim(claim);
        safeResult.setIsFraudulent(false);
        safeResult.setCheckedAt(LocalDateTime.now());

        return resultRepository.save(safeResult);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
