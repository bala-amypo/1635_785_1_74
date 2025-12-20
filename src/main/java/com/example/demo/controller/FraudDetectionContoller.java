package com.example.demo.controller;

import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;

@RestController
@RequestMapping("api/claims")
public class ClaimController{
    @Autowired ClaimService service;
    public ClaimController(ClaimService service){
        this.service=service;
    }
    @PostMapping
    public Claim submitClaim(@RequestBody Claim claim)
}