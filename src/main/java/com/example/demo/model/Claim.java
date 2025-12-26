package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Policy policy;

    private LocalDate claimDate;
    private Double claimAmount;
    private String description;

    @ManyToMany
    @JoinTable(
        name = "claim_fraudrule",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "fraud_rule_id")
    )
    private Set<FraudRule> suspectedRules = new HashSet<>();

    // Custom constructor for tests (without id and suspectedRules)
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    }
}
