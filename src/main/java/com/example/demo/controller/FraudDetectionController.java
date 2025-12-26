package com.example.demo.controller;

import com.example.demo.dto.FraudCheckResult;
import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud")
public class FraudDetectionController {

    private final ClaimService claimService;

    public FraudDetectionController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/check")
    public ResponseEntity<FraudCheckResult> checkFraud(@RequestBody Claim claim) {
        Claim checkedClaim = claimService.checkFraud(claim);

        FraudCheckResult result = new FraudCheckResult(
                checkedClaim.getId(),
                checkedClaim.getPolicy() != null ? checkedClaim.getPolicy().getId() : null,
                checkedClaim.getPolicy() != null ? checkedClaim.getPolicy().getPolicyNumber() : null,
                checkedClaim.getClaimDate(),
                checkedClaim.getClaimAmount(),
                checkedClaim.getDescription(),
                checkedClaim.getSuspectedRules(),
                !checkedClaim.getSuspectedRules().isEmpty()
        );

        return ResponseEntity.ok(result);
    }
}
