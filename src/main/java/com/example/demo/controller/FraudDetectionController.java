package com.example.demo.controller;

import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @GetMapping("/check/{id}")
    public boolean checkClaim(@PathVariable Long id) {
        return fraudDetectionService.checkClaim(id);
    }
}