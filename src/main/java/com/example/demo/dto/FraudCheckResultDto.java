package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResultDto {
    private Long claimId;
    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;
}
