package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "fraud_check_results")
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Claim claim;

    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;
}
