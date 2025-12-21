package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ClaimService;
import com.example.demo.model.Claim;
import com.example.demo.repository.ClaimRepository;
@Service
public class ClaimServiceImpl{
    @Autowired ClaimRepository claimRepository;
    public ClaimServiceImpl(ClaimRepository claimRepository){
        this.claimRepository=claimRepository;
    }
    @Override
    public Claim createClaim(claim claim){
        claim.setStatus("PENDING");
        return claimRepository.save(claim);
    }
    @Override
    public Claim getClaimById(Long id){
        return claimRepository.findById(id).ElseThrow(()->new ResourceNotFoundException("Claim not found"));
    }
}