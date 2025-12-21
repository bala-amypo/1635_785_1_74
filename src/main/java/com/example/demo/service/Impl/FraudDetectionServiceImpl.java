package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.model.FraudRule;
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
    private FraudCheckResultRepository fraudCheckResultRepository;

    @Autowired
    private FraudRuleRepository fraudRuleRepository;

    @Override
    public FraudCheckResult checkClaim(Claim claim) {
        boolean fraudDetected = false;
        String ruleApplied = null;

        List<FraudRule> rules = fraudRuleRepository.findAll();
        for (FraudRule rule : rules) {
            if ("claimAmount".equals(rule.getConditionField())
                    && claim.getClaimAmount() > Double.parseDouble(rule.getValue())) {
                fraudDetected = true;
                ruleApplied = rule.getRuleName();
            }
        }

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setFraudDetected(fraudDetected);
        result.setRuleApplied(ruleApplied);
        result.setCheckedAt(LocalDateTime.now());

        return fraudCheckResultRepository.save(result);
    }
}
