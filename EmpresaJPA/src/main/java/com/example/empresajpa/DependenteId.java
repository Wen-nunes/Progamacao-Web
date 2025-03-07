package com.example.empresajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DependenteId implements Serializable {
    @Column(name = "Fcpf")
    private String funcionario_cpf;
    @Column(name = "dependente_nome")
    private String dependente_nome;

}
