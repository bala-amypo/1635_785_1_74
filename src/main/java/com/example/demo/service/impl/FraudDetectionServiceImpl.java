package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository cr, FraudRuleRepository fr, FraudCheckResultRepository rr) {
        this.claimRepository = cr;
        this.fraudRuleRepository = fr;
        this.resultRepository = rr;
    }

    @Override
    public void checkClaim(Long claimId) {
        // Logic to apply rules from fraudRuleRepository to a claim from claimRepository
        // and save the final report in resultRepository.
    }
}