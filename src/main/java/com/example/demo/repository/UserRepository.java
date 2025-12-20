package com.example.demo.repository;
import org.springframework.data.jpa.repositry.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findbyEmail(String email);
    boolean existsByEmail(String email);
}