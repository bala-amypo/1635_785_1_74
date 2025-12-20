package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController{
    @Autowired PolicyService service;
    public PolicyController(PolicyService service){
        this.service=service;
    }
    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy){
        return service.savePolicy(policy);
    }
    @GetMapping("/user/{userId}")
    public List<Policy>
    
}