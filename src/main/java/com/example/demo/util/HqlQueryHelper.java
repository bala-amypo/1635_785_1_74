package com.example.demo.util;

import com.example.demo.model.Claim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Claim> findHighValueClaims(double amount) {
        return entityManager.createQuery(
                "FROM Claim c WHERE c.claimAmount > :amount", Claim.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return entityManager.createQuery(
                "FROM Claim c WHERE c.description LIKE :kw", Claim.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
    }
}
