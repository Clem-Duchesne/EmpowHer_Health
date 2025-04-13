package com.dev.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.model.UserModels.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // Method to find user by email
    User findByEmail(String email); 
} 