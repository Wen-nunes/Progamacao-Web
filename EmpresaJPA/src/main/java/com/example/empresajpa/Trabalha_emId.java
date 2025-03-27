package com.example.empresajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Trabalha_emId implements Serializable {

    @Column(name = "Fcpf")
    private String funcionario_cpf;

    @Column(name = "Pnumero")
    private int projeto_numero;

}
