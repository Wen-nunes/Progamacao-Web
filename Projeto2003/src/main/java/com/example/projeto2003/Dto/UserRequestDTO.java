package com.example.projeto2003.Dto;

import lombok.Data;
import java.util.List;

@Data
public class UserRequestDTO {
    private String nome;
    private String email;
    private List<PhoneRequestDTO> phones;
} 