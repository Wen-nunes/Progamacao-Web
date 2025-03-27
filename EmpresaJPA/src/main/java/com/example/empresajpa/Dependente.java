package com.example.empresajpa;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Dependente {
    @Id
    @EmbeddedId
    private DependenteId id;
    private String sexo;
    private Date dataNasc;

    @ManyToOne
    @JoinColumn(name = "Fcpf")
    @MapsId("funcionario_cpf")
    private Funcionario parentesco;

}
