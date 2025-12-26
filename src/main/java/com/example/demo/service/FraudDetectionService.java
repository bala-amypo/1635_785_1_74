package com.example.demo.service;

import com.example.demo.model.Claim;

public interface FraudDetectionService {
    void detectFraud(Claim claim);
}
