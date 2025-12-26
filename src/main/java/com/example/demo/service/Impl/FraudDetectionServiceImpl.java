package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import com.example.demo.model.Claim;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.service.FraudDetectionService;
@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudRuleRepository fraudRuleRepository,
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void detectFraud(Claim claim) {
        // Simulate detection, just mark as done
        claimRepository.save(claim);
    }
}
