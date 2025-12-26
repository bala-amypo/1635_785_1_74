package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud-detection")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<String> analyzeClaim(@RequestBody Claim claim) {
        fraudDetectionService.detectFraud(claim);
        return ResponseEntity.ok("Fraud analysis completed");
    }
}
