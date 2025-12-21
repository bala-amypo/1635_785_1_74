package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping("/check")
    public FraudCheckResult checkFraud(@RequestBody Claim claim) {
        return fraudDetectionService.checkClaim(claim);
    }
}
