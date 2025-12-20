package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.FraudRule;
import com.examle.demo.service.FraudRuleService;

@RestController
@RequestMapping("/api/rules")
public class FraudRuleController{
    @Autowired FraudRuleService service;

    public FraudRuleController(FraudRuleService service){
        this.service=service;
    }
    @PostMapping
    public FraudRule addRule(@RequestBody FraudRule rule){
        return service.saveRule(rule);
    }
    @GetMapping
    public List<FraudRule> getRules(){
        return service.getAllRules();
    }
}