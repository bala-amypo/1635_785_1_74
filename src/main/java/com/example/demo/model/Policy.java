package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "policy")
    private Set<Claim> claims = new HashSet<>();

    // Custom constructor for tests
    public Policy(String policyNumber, LocalDate startDate, LocalDate endDate, User user) {
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
}
