package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Change 'amount' to 'claimAmount' to match getClaimAmount()
    private Double claimAmount; 
    
    private LocalDate claimDate;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Change 'triggeredRules' to 'suspectedRules' to match getSuspectedRules()
    @ManyToMany
    private Set<FraudRule> suspectedRules = new HashSet<>();

    // Update the custom constructor to use the new names
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.status = "PENDING";
    }
}