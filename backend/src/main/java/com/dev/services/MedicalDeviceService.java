package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.MedicalDeviceModels.MedicalDevice;
import com.dev.repository.MedicalDeviceRepository;

@Service
public class MedicalDeviceService{
        @Autowired
        private MedicalDeviceRepository medicalDeviceRepository;

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