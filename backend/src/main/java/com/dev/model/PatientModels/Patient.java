package com.dev.model.PatientModels;

import com.dev.model.UserModels.User;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "patient")
    private User user;
    
   

    
}