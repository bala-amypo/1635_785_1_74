package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {
    private Long id;
    private Long userId;
    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
}
