package com.example.demo.service.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
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
    public P
}