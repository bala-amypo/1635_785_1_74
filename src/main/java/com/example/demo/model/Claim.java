package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "claims")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Renamed from 'amount' to 'claimAmount' to satisfy ClaimServiceImpl calls
    private Double claimAmount;

    private LocalDate claimDate;
    private String description;
    private String status; // Usually PENDING, APPROVED, or REJECTED

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Renamed to 'suspectedRules' to satisfy ClaimServiceImpl and bidirectional mapping
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "claim_fraud_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "fraud_rule_id")
    )
    private Set<FraudRule> suspectedRules = new HashSet<>();

    /**
     * Custom constructor specifically required by DemoApplicationTests.java.
     * The test calls: new Claim(policy, date, amount, description)
     */
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.status = "PENDING"; // Default status for new submissions
    }
}