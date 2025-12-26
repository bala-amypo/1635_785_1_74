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
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String field;
    private String operator;
    private String threshold;
    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    // 🔴 REQUIRED for tests
    public FraudRule(String ruleName, String field, String operator, String threshold, String severity) {
        this.ruleName = ruleName;
        this.field = field;
        this.operator = operator;
        this.threshold = threshold;
        this.severity = severity;
        this.claims = new HashSet<>();
    }
}
