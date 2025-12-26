package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;

    // 🔴 REQUIRED for tests
    public Policy(User user, String policyNumber, String policyType,
                  LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
