package com.example.empresajpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Funcionario {
    @Id
    private String cpf;

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

    @OneToOne(mappedBy = "gerente")
    private Departamento departamentoGerente;

    @ManyToOne
    @JoinColumn(name = "dnumero")
    private Departamento departamento;

    @OneToMany(mappedBy = "trabalha_em")
    private List<Trabalha_Em> listaProjetos;

}
