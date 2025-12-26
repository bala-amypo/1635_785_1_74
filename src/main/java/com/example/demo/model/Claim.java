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
    private Set<FraudRule> suspectedRules = new HashSet<>();

    // 🔴 REQUIRED for tests
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.suspectedRules = new HashSet<>();
    }
}
