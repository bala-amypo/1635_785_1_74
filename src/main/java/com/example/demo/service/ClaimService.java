package com.example.demo.service;

import com.example.demo.model.Claim;
import java.util.List;
import java.util.Optional;

public interface ClaimService {
    // Tests call createClaim(Long policyId, Claim claim)
    Claim createClaim(Long policyId, Claim claim); 
    List<Claim> getAllClaims();
    Claim getClaim(Long id); // Note: Return Claim directly, not Optional
    Claim updateClaimStatus(Long id, String status);
    void deleteClaim(Long id);
}