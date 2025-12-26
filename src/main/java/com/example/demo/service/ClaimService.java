package com.example.demo.service;

import com.example.demo.model.Claim;
import java.util.List;

public interface ClaimService {
    // Tests specifically call this signature at lines 184, 196, and 207
    Claim createClaim(Long policyId, Claim claim); 
    List<Claim> getAllClaims();
    Claim getClaim(Long id); 
    Claim updateClaimStatus(Long id, String status);
    void deleteClaim(Long id);
}