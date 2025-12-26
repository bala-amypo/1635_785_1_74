package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public ResponseEntity<Claim> createClaim(@PathVariable Long policyId, @RequestBody Claim claim) {
        Claim saved = claimService.createClaim(policyId, claim);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<Claim> getClaim(@PathVariable Long claimId) {
        Claim claim = claimService.getClaim(claimId);
        return ResponseEntity.ok(claim);
    }
}
