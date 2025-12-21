package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping("/check")
    public FraudCheckResult checkFraud(@RequestBody Claim claim) {
        return fraudDetectionService.checkFraud(claim);
    }

    @GetMapping("/all")
    public List<FraudCheckResult> getAllFraudResults() {
        return fraudDetectionService.getAllResults();
    }
}
