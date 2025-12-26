package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor
public class Claim {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Policy policy;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;

    @ManyToMany
    @JoinTable(name = "claim_fraud_rules")
    private Set<FraudRule> suspectedRules = new HashSet<>();

    public Claim(Policy policy, LocalDate date, Double amount, String desc) {
        this.policy = policy;
        this.claimDate = date;
        this.claimAmount = amount;
        this.description = desc;
    }
}