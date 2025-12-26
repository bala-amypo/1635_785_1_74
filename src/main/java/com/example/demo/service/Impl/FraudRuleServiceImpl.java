package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.Optional;
@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (!rule.getSeverity().equals("HIGH") &&
            !rule.getSeverity().equals("MEDIUM") &&
            !rule.getSeverity().equals("LOW")) {
            throw new IllegalArgumentException("Invalid severity");
        }
        return fraudRuleRepository.save(rule);
    }
}
