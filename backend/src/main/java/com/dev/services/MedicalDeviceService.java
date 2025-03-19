package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.controller.RequiredArgsConstructor;
import com.dev.model.MedicalDeviceModels.MedicalDevice;
import com.dev.repository.MedicalDeviceRepository;

@Service
@RequiredArgsConstructor
public class MedicalDeviceService{

        private final MedicalDeviceRepository medicalDeviceRepository;

        public MedicalDeviceService(MedicalDeviceRepository deviceRepository) {
            this.medicalDeviceRepository = deviceRepository;
        }

        public MedicalDevice CreateMedicalDevice(MedicalDevice medicalDevice) {
            return medicalDeviceRepository.save(medicalDevice);
        }

        public List<MedicalDevice> GetMedicalDevices() {
            return medicalDeviceRepository.findAll();
        }

        public Optional<MedicalDevice> GetMedicalDeviceByID(Long id){
            return medicalDeviceRepository.findById(id);
        }

        public boolean DeleteMedicalDevice(Long id){
            try{
                medicalDeviceRepository.deleteById(id);
                return true;
            }
            catch(Exception e){
                return false;
            }
        }

}