package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "claims")
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Policy policy;

    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status;

    @ManyToMany
    private Set<FraudRule> suspectedRules;

    @OneToOne(mappedBy = "claim")
    private FraudCheckResult fraudCheckResult;
}
