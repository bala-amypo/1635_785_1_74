package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
 import com.example.demo.model.Claim;
 import java.util.List;
public interface ClaimRepository extends JpaRepository<Claim,Long>{
    List<Claim> findByPolicy(Long policyId)
}