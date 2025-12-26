package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {
    private Long id;
    private String ruleName;
    private String fieldName;
    private String operator;
    private String value;
    private String severity;
    private Set<Claim> claims = new HashSet<>();

    public FraudRule(String ruleName, String fieldName, String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.fieldName = fieldName;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }
}