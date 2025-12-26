package com.example.demo.dto;

import com.example.demo.model.FraudRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResult {
    private Long claimId;
    private Long policyId;
    private String policyNumber;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private Set<FraudRule> suspectedRules; // Rules triggered for this claim
    private boolean isFraudulent; // true if suspectedRules is not empty
}
