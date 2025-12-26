package com.example.demo.service;

import com.example.demo.model.Claim;
import java.util.List;
import java.util.Optional;

public interface ClaimService {
    Claim submitClaim(Claim claim);
    List<Claim> getAllClaims();
    Optional<Claim> getClaim(Long id); // Changed from getClaimById to getClaim
    Claim updateClaimStatus(Long id, String status);
    void deleteClaim(Long id);
}