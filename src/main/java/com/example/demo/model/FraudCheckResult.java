package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchedRules;
}