package com.example.projeto2003.controller;

import com.example.projeto2003.Dto.PhoneRequestDTO;
import com.example.projeto2003.Dto.PhoneResponseDTO;
import com.example.projeto2003.service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<PhoneResponseDTO> createPhone(@PathVariable Long userId, @RequestBody PhoneRequestDTO phoneRequestDTO) {
        PhoneResponseDTO createdPhone = phoneService.createPhone(userId, phoneRequestDTO);
        return ResponseEntity.ok(createdPhone);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PhoneResponseDTO>> getAllPhonesByUserId(@PathVariable Long userId) {
        List<PhoneResponseDTO> phones = phoneService.getAllPhonesByUserId(userId);
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneResponseDTO> getPhoneById(@PathVariable Long id) {
        PhoneResponseDTO phone = phoneService.getPhoneById(id);
        return ResponseEntity.ok(phone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneResponseDTO> updatePhone(@PathVariable Long id, @RequestBody PhoneRequestDTO phoneRequestDTO) {
        PhoneResponseDTO updatedPhone = phoneService.updatePhone(id, phoneRequestDTO);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
} 