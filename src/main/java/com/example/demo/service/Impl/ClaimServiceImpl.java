package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository, FraudRuleRepository fraudRuleRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public Claim checkFraud(Claim claim) {
        // Simple example: mark claim as suspected if claimAmount > 10000
        List<FraudRule> allRules = fraudRuleRepository.findAll();

        for (FraudRule rule : allRules) {
            if (rule.getSeverity() > 5 && claim.getClaimAmount() != null && claim.getClaimAmount() > 10000) {
                claim.getSuspectedRules().add(rule);
            }
        }

        return claimRepository.save(claim);
    }
}
