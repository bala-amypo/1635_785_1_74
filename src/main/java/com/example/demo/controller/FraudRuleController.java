
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;

@RestController
@RequestMapping("/fraud-rule")
public class FraudRuleController {

    private final FraudDetectionService fraudDetectionService;

    public FraudRuleController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/check")
    public FraudCheckResult checkClaim(@RequestBody Claim claim) {
        return fraudDetectionService.checkFraud(claim);
    }
}
