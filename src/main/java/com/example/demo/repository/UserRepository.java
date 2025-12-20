package com.example.demo.repository;
import org.springframework.data.jpa.repositry.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.enitity.User
@Repository;
public interface UserRepository extends JpaRepository<User, Long>{
    
}