package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; i
import com.example.demo.model.Policy;
import com.example.demo.model.User;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
    Optional<Policy>findByPolicyNumber(String policyNumber);
    boolean existsByPolicyNumber(String policyNumber);

    List<Policy> findByuserId(Long userId);
}