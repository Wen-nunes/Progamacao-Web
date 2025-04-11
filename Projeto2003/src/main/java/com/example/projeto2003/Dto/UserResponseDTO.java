package com.example.projeto2003.Dto;

import lombok.Data;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private List<PhoneResponseDTO> phones;
} 