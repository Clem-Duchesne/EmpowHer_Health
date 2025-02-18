package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.MedicalDevice;


@Repository
public interface MedicalDeviceRepository extends JpaRepository<MedicalDevice, Long> {
}
