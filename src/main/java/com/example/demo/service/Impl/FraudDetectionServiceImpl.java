package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.FraudDetectionService;
import com.example.demo.model.FraudDetection;
import com.example.demo.repository.FraudDetectionRepository;
@Service
public class FraudDetectionServiceImpl{
    @Autowired FraudCheckResultRepository fraudCheckResultRepository;
    public FraudDetectionServiceImpl(FraudCheckResultRepository fraudCheckResultRepository){
        this.fraudCheckResultRepository=fraudCheckResultRepository;
    }
    @Override
    public FraudCheckResult saveFraudResult(FraudCheckResult result){
        return fraudCheckResultRepository.save(result);
    }
    @Override
    public FraudChecResultRepository.findByClaim(claim).orElseThrow(()->new ResourceNotFoundException("Fraud result not found"));
}