package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;
    private int severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    // Custom constructor for tests
    public FraudRule(String ruleName, String description, int severity) {
        this.ruleName = ruleName;
        this.description = description;
        this.severity = severity;
    }
}
