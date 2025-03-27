package com.example.empresajpa;
import jakarta.persistence.*;

@Entity
public class Trabalha_Em {
    @Id
    @EmbeddedId
    private Trabalha_emId id;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "Pnumero")
    @MapsId("projeto_numero")
    private Projetos trabalha;

    @ManyToOne
    @JoinColumn(name = "Fcpf")
    @MapsId("funcionario_cpf")
    private Funcionario trabalha_em;
}
