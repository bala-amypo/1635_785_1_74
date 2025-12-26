package com.example.demo.controller;

import com.example.demo.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-detection")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/check/{claimId}")
    public ResponseEntity<String> checkClaim(@PathVariable Long claimId) {
        // This links to the FraudDetectionServiceImpl required in the setup()
        fraudDetectionService.checkClaim(claimId);
        return ResponseEntity.ok("Fraud check completed for claim " + claimId);
    }
}