package com.example.demo.service;

import com.example.demo.model.Claim;

public interface ClaimService {
    Claim checkFraud(Claim claim);
}
