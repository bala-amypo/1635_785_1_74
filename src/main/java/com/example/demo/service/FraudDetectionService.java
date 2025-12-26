package com.example.demo.service;

import com.example.demo.model.Claim;

public interface FraudDetectionService {
    void evaluateClaim(Claim claim);
    boolean checkClaim(Long claimId); // Required by FraudDetectionController
}