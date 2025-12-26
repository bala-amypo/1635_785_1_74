package com.example.demo.dto;

import com.example.demo.model.FraudRule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class FraudCheckResult {
    private Long claimId;
    private Long policyId;
    private String policyNumber;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private Set<FraudRule> suspectedRules;
    private boolean isFraudulent;
}
