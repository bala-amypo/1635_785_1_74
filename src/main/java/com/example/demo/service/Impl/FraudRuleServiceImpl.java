package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    public FraudRule addRule(FraudRule rule) {
        if (repo.findByRuleName(rule.getRuleName()).isPresent())
            throw new IllegalArgumentException("Duplicate rule name");

        if (!rule.getSeverity().matches("LOW|MEDIUM|HIGH"))
            throw new IllegalArgumentException("Invalid severity");

        return repo.save(rule);
    }

    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
