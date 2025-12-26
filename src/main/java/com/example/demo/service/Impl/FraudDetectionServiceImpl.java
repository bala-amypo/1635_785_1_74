package com.example.demo.service.impl;

import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudDetectionService;

public class FraudDetectionServiceImpl implements FraudDetectionService {
    public FraudDetectionServiceImpl(ClaimRepository claimRepository, 
                                     FraudRuleRepository fraudRuleRepository, 
                                     FraudCheckResultRepository resultRepository) {
    }
}