package com.example.demo.util;
import com.example.demo.model.Claim;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HqlQueryHelper {
    // These would normally use EntityManager to run real HQL/HCQL
    public List<Claim> findHighValueClaims(Double amount) { return new ArrayList<>(); }
    public List<Claim> findClaimsByDescriptionKeyword(String kw) { return new ArrayList<>(); }
}