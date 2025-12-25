package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRuleDto {
    private Long id;
    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String severity;
}
