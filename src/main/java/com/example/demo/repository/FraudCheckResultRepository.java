package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.model.Claim;
public interface FraudCheckResultRepository extends JpaRepository<FraudCheckResult,Long>{
    Optional<FraudCheckResult> findByClaim(Claim claim);
    
}