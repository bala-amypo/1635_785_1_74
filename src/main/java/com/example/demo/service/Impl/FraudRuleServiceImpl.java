package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.service.FraudDetectionService;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final FraudCheckResultRepository fraudCheckResultRepository;

    public FraudDetectionServiceImpl(FraudCheckResultRepository fraudCheckResultRepository) {
        this.fraudCheckResultRepository = fraudCheckResultRepository;
    }

    @Override
    public FraudCheckResult checkFraud(Claim claim) {
        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setFraudDetected(claim.getClaimAmount() > 50000);
        result.setRuleApplied("AMOUNT_THRESHOLD");
        result.setCheckedAt(LocalDateTime.now());

        return fraudCheckResultRepository.save(result);
    }

    @Override
    public List<FraudCheckResult> getAllResults() {
        return fraudCheckResultRepository.findAll();
    }
}
