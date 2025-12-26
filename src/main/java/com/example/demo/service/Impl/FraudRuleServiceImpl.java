package com.example.demo.service.impl;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository repository;
    private final List<String> VALID_SEVERITIES = List.of("LOW", "MEDIUM", "HIGH");

    public FraudRuleServiceImpl(FraudRuleRepository repo) { this.repository = repo; }

    public FraudRule addRule(FraudRule rule) {
        if (!VALID_SEVERITIES.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }
        return repository.save(rule);
    }
}