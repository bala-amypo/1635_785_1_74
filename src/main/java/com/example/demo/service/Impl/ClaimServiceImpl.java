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

    public Claim createClaim(Long policyId, Claim claim) {
        if (claim.getClaimDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Future date");
        if (claim.getClaimAmount() < 0) throw new IllegalArgumentException("Negative amount");
        
        Policy p = policyRepo.findById(policyId).orElseThrow();
        claim.setPolicy(p);
        return claimRepo.save(claim);
    }

    public Claim getClaim(Long id) {
        return claimRepo.findById(id).orElseThrow();
    }
}