package com.dev.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dev.controller.RequiredArgsConstructor;

import com.dev.repository.MedicalDeviceRepository;
import com.dev.model.MedicalDevice;
@Service
@RequiredArgsConstructor

public class MedicalDeviceService{

        private final MedicalDeviceRepository medicalDeviceRepository;

        public MedicalDeviceService(MedicalDeviceRepository deviceRepository) {
            this.medicalDeviceRepository = deviceRepository;
        }

        public MedicalDevice registerDevice(MedicalDevice medicalDevice) {
            return medicalDeviceRepository.save(medicalDevice);
        }

        public List<MedicalDevice> getDevices() {
            return medicalDeviceRepository.findAll();
        }

    

}