package com.example.demo.controller;

import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-check")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping("/evaluate/{claimId}")
    public FraudCheckResult evaluateClaim(@PathVariable Long claimId) {
        return fraudDetectionService.evaluateClaim(claimId);
    }

    @GetMapping("/result/claim/{claimId}")
    public FraudCheckResult getResultByClaim(@PathVariable Long claimId) {
        return fraudDetectionService.getResultByClaim(claimId);
    }
}
