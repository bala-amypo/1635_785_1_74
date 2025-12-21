package com.example.demo.service;
package com.example.demo.modelFraudDetection;

public class FraudDetectionService{
    FraudCheckResult evaluateClaim(Long claimId);
    FraudCheckResult getResultByClaim(Long claimId);
}