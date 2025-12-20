package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;

@RestController
@RequestMapping("/api/fraud-check")
public class FraudDetectionController{
    @Autowired FraudDetectionService service;
    public FraudDetectionController(FraudDetectionService service){
        this.service=service;
    }
    @PostMapping("/evaluate/{claimId}")
    public FraudCheckResult evaluate(@PathVAriable Long claimId){
        return service.evaluateClaim(claimId);
    }
    @GetMapping("/result/claim/{claimId}")
    public FraudCheckResult getResult(@PathVariable Long claimId){
        return service.getResultByClaim(claimId);
    }
}