package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ruleName;
    private String description;
    private Integer severity;
    
    // New fields required by the test's getClaims/setClaims calls
    private String category;
    private String status;
    private String ruleType;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    // Custom constructor to satisfy the test's 5-String argument call
    // Based on the error: FraudRule(String, String, String, String, String)
    public FraudRule(String ruleName, String description, String category, String status, String ruleType) {
        this.ruleName = ruleName;
        this.description = description;
        this.category = category;
        this.status = status;
        this.ruleType = ruleType;
        this.severity = 1; // Default severity
    }
}