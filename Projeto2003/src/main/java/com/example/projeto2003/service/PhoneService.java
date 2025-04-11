package com.example.projeto2003.service;

import com.example.projeto2003.Dto.PhoneRequestDTO;
import com.example.projeto2003.Dto.PhoneResponseDTO;
import com.example.projeto2003.Phone;
import com.example.projeto2003.User;
import com.example.projeto2003.repository.PhoneRepository;
import com.example.projeto2003.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    public PhoneResponseDTO createPhone(Long userId, PhoneRequestDTO phoneRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Phone phone = new Phone(user, phoneRequestDTO.getNumero());
        Phone savedPhone = phoneRepository.save(phone);
        return convertToResponseDTO(savedPhone);
    }

    public List<PhoneResponseDTO> getAllPhonesByUserId(Long userId) {
        return phoneRepository.findByUserId(userId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PhoneResponseDTO getPhoneById(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        return convertToResponseDTO(phone);
    }

    public PhoneResponseDTO updatePhone(Long id, PhoneRequestDTO phoneRequestDTO) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));

        phone.setNumero(phoneRequestDTO.getNumero());
        Phone updatedPhone = phoneRepository.save(phone);
        return convertToResponseDTO(updatedPhone);
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    private PhoneResponseDTO convertToResponseDTO(Phone phone) {
        PhoneResponseDTO responseDTO = new PhoneResponseDTO();
        responseDTO.setId(phone.getId());
        responseDTO.setNumero(phone.getNumero());
        return responseDTO;
    }
} 