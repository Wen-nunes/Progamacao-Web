package com.example.apifinanceiro.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "fornecedor")
    private List<Venda> vendas;

    public Fornecedor(int id, String nome, List<Venda> vendas, String endereco) {
        this.id = id;
        this.nome = nome;
        this.vendas = vendas;
        this.endereco = endereco;
    }

    public Fornecedor(String nome, String endereco, List<Venda> vendas) {
        this.nome = nome;
        this.endereco = endereco;
        this.vendas = vendas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
