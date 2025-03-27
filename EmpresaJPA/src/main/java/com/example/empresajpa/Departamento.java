package com.example.empresajpa;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dnumero;

    private String dnome;


    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Localizacoes> localizacoes;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario gerente;
    private Date data_inicio_gerente;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "departamento")
    private List<Projetos> projetos;

}
