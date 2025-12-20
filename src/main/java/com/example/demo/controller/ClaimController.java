package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController{
    @Autowired ClaimService service;

    public ClaimController(ClaimService service){
        this.service=service
    }
    @PostMapping
    public Claim submitClaim(@RequestBody Claim claim){
        return service.saveClaim(claim);
    }
    @GetMapping("/{id}")
    public Claim getClaim(@PathVariable Long id){
        return service.getClaimById(id)
    }
    
}