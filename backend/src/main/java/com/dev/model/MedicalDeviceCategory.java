package com.dev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_device_category")
public class MedicalDeviceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = true)
    private String description;

    public MedicalDeviceCategory()
    {}

    // Getters et Setters (obligatoires pour JPA)
    public Long getId() { return category_id; }
    public void setId(Long id) { this.category_id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


}