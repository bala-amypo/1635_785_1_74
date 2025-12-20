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
    public Claim submitClaim(@RequestBody Claim claim){
        return servie.saveClaim(Claim);
    }
    @GetMapping("/{id}")
    public Claim getClaim(@PathVariable Long id){
        return service.getClaimById(id);
    }
    }