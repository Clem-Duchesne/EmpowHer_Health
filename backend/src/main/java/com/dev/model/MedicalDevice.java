package com.dev.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_device")
public class MedicalDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(unique = true)
    private String serial_number;

    @ElementCollection  // Pour stocker une liste de valeurs simples (ex: `List<String>`)
    private List<String> undesired_effects;

    @ManyToOne  // Une relation plusieurs-à-un avec MedicalDeviceCategory
    @JoinColumn(name = "category_id")
    private MedicalDeviceCategory category;

    @Column
    private boolean certified_CE;

    @Column
    private boolean commercialized;

    @Column(length = 100)
    private String constructor;

    @Column(length = 100)
    private String certification_organism;

    @Column(length = 100)
    private String competent_authority;

    @Column
    private boolean has_undesired_effects;

    // Constructeur par défaut obligatoire pour Hibernate
    public MedicalDevice() {}

    // Constructeur personnalisé
    public MedicalDevice(Long id, String name, String description, MedicalDeviceCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters et Setters (obligatoires pour JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSerialNumber() { return serial_number; }
    public void setSerialNumber(String serial_number) { this.serial_number = serial_number; }

    public MedicalDeviceCategory getCategory() { return category; }
    public void setCategory(MedicalDeviceCategory category) { this.category = category; }

    public boolean isCertifiedCE() { return certified_CE; }
    public void setCertifiedCE(boolean certified_CE) { this.certified_CE = certified_CE; }

    public boolean isCommercialized() { return commercialized; }
    public void setCommercialized(boolean commercialized) { this.commercialized = commercialized; }

    public String getConstructor() { return constructor; }
    public void setConstructor(String constructor) { this.constructor = constructor; }

    public String getCertificationOrganism() { return certification_organism; }
    public void setCertificationOrganism(String certification_organism) { this.certification_organism = certification_organism; }

    public String getCompetentAuthority() { return competent_authority; }
    public void setCompetentAuthority(String competent_authority) { this.competent_authority = competent_authority; }

    public boolean hasUndesiredEffects() { return has_undesired_effects; }
    public void setHasUndesiredEffects(boolean has_undesired_effects) { this.has_undesired_effects = has_undesired_effects; }

    public List<String> getUndesiredEffects() { return undesired_effects; }
    public void setUndesiredEffects(List<String> undesired_effects) { this.undesired_effects = undesired_effects; }
}

