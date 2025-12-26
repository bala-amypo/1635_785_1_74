package com.example.demo.controller;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Policy> createPolicy(@PathVariable Long userId, @RequestBody Policy policy) {
        Policy saved = policyService.createPolicy(userId, policy);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Policy>> getPolicies(@PathVariable Long userId) {
        List<Policy> policies = policyService.getPoliciesByUser(userId);
        return ResponseEntity.ok(policies);
    }
}
