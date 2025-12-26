package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Policy> policies = new HashSet<>();

    // Custom constructor for tests
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
