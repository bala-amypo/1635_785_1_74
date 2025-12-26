package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDate claimDate;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToMany
    private Set<FraudRule> triggeredRules;

    // Manual constructor to satisfy the test's specific 4-argument call
    public Claim(Policy policy, LocalDate claimDate, Double amount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.amount = amount;
        this.description = description;
        this.status = "PENDING"; // Default status
    }
}