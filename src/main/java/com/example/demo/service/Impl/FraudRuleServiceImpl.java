package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import java.util.List;

public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (!List.of("LOW", "MEDIUM", "HIGH").contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }
        return repository.save(rule);
    }
}