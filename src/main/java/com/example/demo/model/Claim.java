package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
// Inside com.example.demo.model.Claim
@Data
@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double claimAmount;
    private LocalDate claimDate;
    private String description;
    private String status; // ADD THIS LINE
    
    @ManyToOne
    private Policy policy;
}