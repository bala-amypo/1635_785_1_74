package com.example.demo.service;
import com.example.demo.model.FraudRule
import java.util.List;
public class FraudRuleService{
    FraudRule addRule(FraudRule rule);
    List<FraudRule> getAllRules();
}