package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public FraudCheckResult getResult(@PathVariable Long claimId) {
        return fraudDetectionService.getResultByClaim(claimId);
    }
}
