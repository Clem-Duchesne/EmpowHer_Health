package com.dev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.MedicalDeviceModels.MedicalDevice;
import com.dev.services.MedicalDeviceService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/devices")
public class MedicalDeviceController {
    @Autowired
    private MedicalDeviceService medicalDeviceService;

    @GetMapping()
    public List<MedicalDevice> getMedicalDevices() {
        return medicalDeviceService.GetMedicalDevices();
    }

    @GetMapping("/{id}")
    public Optional<MedicalDevice> getMedicalDevice(@RequestParam Long id) {
        return medicalDeviceService.GetMedicalDeviceByID(id);
    }

    @DeleteMapping("/{id}")
    public boolean requestMethodName(@RequestParam Long id) {
        return medicalDeviceService.DeleteMedicalDevice(id);
    }


    @PostMapping("/register")
    public ResponseEntity<MedicalDevice> registerMedicalDevice(@RequestBody MedicalDevice device) {
        return ResponseEntity.ok(medicalDeviceService.CreateMedicalDevice(device));
    }

    

    
    

}
