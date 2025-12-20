package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResult{
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private Claim claim;
    private Boolean isFradulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;
}