package com.example.empresajpa;

import jakarta.persistence.*;

@Entity
public class Localizacoes {
    @EmbeddedId
    private LocalizacaoId localizacaoId;

    @ManyToOne
    @JoinColumn(name = "dnumero_")
    private Departamento departamento;


}
