package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor
public class FraudRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String field;
    private String operator;
    private String value;
    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    public FraudRule(String name, String field, String op, String val, String sev) {
        this.ruleName = name;
        this.field = field;
        this.operator = op;
        this.value = val;
        this.severity = sev;
    }
}