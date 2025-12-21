package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;

public interface FraudDetectionService {

    FraudCheckResult checkFraud(Claim claim);

    List<FraudCheckResult> getAllResults();
}
