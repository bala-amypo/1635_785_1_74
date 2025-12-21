package com.example.demo.service.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.FraudRuleService;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
@Service
public class FraudRuleServiceImpl{
    @Autowired FraudRuleRepository fraudRuleRepository;
    public FraudRuleRepository(FraudRuleRepository fraudRuleRepository){
        this.fraudRuleRepository=fraudRuleRepository;
    }
    @Override
    public FraduRule addRule(FraudRule rule){
        if(fraudRuleRepository.existsByRuleName(rule,getRuleName())){
            throw new IllegelArgumentException("Duplicate rule name");
        }
        return fraudRuleRepository.save(rule);
    }
    @Override
    public List<FraudRule> getAllRule(){
        return fraudRuleRepository.findAll();
    }
}