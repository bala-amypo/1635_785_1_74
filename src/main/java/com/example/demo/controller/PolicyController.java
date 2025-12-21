package com.example.demo.controller;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/{userId}")
    public Policy createPolicy(@PathVariable Long userId,
                               @RequestBody Policy policy) {
        return policyService.createPolicy(userId, policy);
    }

    @GetMapping("/user/{userId}")
    public List<Policy> getPoliciesByUser(@PathVariable Long userId) {
        return policyService.getPoliciesByUser(userId);
    }
}
