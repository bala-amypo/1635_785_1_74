package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity @Data
public class FraudCheckResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchedRules;
}