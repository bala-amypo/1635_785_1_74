package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDto {
    private Long id;
    private Long policyId;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status;
}
