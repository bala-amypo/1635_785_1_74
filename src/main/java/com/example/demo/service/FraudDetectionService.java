package com.example.demo.service;

import com.example.demo.model.Claim;

public interface FraudDetectionService {
    void evaluateClaim(Claim claim);
    boolean checkClaim(Long claimId); // Add this back for the Controller
}