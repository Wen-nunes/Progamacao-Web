package com.example.empresajpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pnumero;
    private String projnome;
    private String projlocal;

    @ManyToOne
    @JoinColumn(name = "dnumero")
    private Departamento departamento;

    @OneToMany(mappedBy = "trabalha")
    private List<Trabalha_Em> listaFuncionarios;
}
