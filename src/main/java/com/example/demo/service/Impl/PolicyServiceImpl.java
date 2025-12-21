package com.example.demo.service.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.PolicyService;
import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepository;
@Service
public class PolicyServiceImpl{
    @Autowired PolicyRepository policyRepository;

    public PolicyServiceImple(PolicyRepository policyRepository){
        this.policyRepository=policyRepository;
    }
    @Override
    public Policy createPolicy (Policy policy){
        if(policyRepository.existsByPolicyNumber(policy.getPolicyNumber())){
            throw new IllegelArgumentException("Duplicate policy number");
        }
        return policyRepository.save(policy);
    }
    @Override
    public Policy findByPolicyNumber(String policyNumber){
        return policyRepository.findByPolicyNumber(policyNumber).orElseThrow(()->new ResourceNotFoundException("Policy not found"));
    }
    @Override
    public List<Policy> getPoliciesByUserId(Long userId){
        return policyRepository.findByUSerId(userId);
    }
}