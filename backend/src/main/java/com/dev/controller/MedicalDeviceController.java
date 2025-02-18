package com.dev.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.MedicalDevice;
import com.dev.service.MedicalDeviceService;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class MedicalDeviceController {

    private final MedicalDeviceService medicalDeviceService;

    public MedicalDeviceController(MedicalDeviceService medicalDeviceService)
    {
        this.medicalDeviceService = medicalDeviceService;
    }

    @PostMapping("/register")
    public ResponseEntity<MedicalDevice> registerDevice(@RequestBody MedicalDevice device) {
        return ResponseEntity.ok(medicalDeviceService.registerDevice(device));
    }

    @GetMapping()
    public List<MedicalDevice> getDevices() {
        return medicalDeviceService.getDevices();
    }

}
