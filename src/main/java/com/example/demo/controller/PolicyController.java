package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Policy> getPoliciesByUser(@PathVariable Long UserId){
        return service.getPoliciesByUser(userId);
    }
    
}