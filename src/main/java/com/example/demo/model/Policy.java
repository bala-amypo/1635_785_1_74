package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Data @NoArgsConstructor

@AllArgsConstructor
public class Policy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;

    public Policy(User user, String policyNumber, String policyType, LocalDate start, LocalDate end) {
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = start;
        this.endDate = end;
    }
}