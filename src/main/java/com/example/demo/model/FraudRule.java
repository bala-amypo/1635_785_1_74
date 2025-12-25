package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "fraud_rules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String conditionField;
    private String operator;
    private String value;
    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims;
}
