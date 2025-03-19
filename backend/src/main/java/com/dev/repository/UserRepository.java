package com.dev.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.model.UserModels.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
} 