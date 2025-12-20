package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController{
    @Autowired ClaimService service;

    public ClaimController(ClaimService service){
        this.service=service
    }
    
}