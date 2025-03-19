package com.dev.repository;


import com.dev.model.PatientModels.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    
}