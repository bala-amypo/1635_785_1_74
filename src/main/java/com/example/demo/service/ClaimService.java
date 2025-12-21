package com.example.demo.service;
package com.example.demo.model.Claim;
import java.util.List;
public class ClaimService{
    Claim createClaim(Long policyId,Claim claim);
    Claim getClaim(Long claimId);
    List<Claim>getAllClaims();
}