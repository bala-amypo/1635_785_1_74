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
        this.fraudCheckResultRepository=fraudCheckResultRepository
    }
}