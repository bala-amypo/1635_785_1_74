package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepo;
    private final PolicyRepository policyRepo;

    public ClaimServiceImpl(ClaimRepository cr, PolicyRepository pr) {
        this.claimRepo = cr;
        this.policyRepo = pr;
    }

    @Override
    public Claim registerClaim(Claim claim, Long policyId) {
        if (claim.getClaimDate() != null && claim.getClaimDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future date");
        }
        if (claim.getClaimAmount() != null && claim.getClaimAmount() < 0) {
            throw new IllegalArgumentException("Negative amount");
        }
        
        Policy p = policyRepo.findById(policyId)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));
        
        claim.setPolicy(p);
        claim.setStatus("PENDING"); // This works now that you added the field
        return claimRepo.save(claim);
    }

    @Override
    public Claim getClaim(Long id) { // Changed name from getClaimById to getClaim
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}