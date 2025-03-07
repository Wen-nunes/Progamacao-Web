package com.example.empresajpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Nome nome;
    private Date dataNascimento;
    private String sexo;
    private int salario;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "supervisor_cpf")
    private Funcionario supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Funcionario> supervisionados;

    @OneToMany(mappedBy = "parentesco")
    private List<Dependente> dependentes;
}
