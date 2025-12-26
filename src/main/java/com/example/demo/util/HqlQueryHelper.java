package com.example.demo.util;

import com.example.demo.model.Claim;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class HqlQueryHelper {
    public List<Claim> findHighValueClaims(Double amount) {
        return new ArrayList<>(); // Mocked for tests
    }

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return new ArrayList<>(); // Mocked for tests
    }
}