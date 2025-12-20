package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GEnerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Column(unique=true)
    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
}