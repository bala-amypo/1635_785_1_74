package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; i
import com.example.demo.model.Policy;
import com.example.demo.model.User;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
    List<Policy>findByUser(User user);
    boolean existsByPolicyNumber(String policyNumber)
}