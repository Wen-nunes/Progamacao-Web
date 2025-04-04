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
    private float credito;
    private float debito;

    @OneToMany(mappedBy = "fornecedor")
    private List<Venda> vendas;

    public Fornecedor(int id, String nome, String endereco, float credito, float debito) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.credito = credito;
        this.debito = debito;
    }

    public Fornecedor(String nome, String endereco, float credito, float debito) {
        this.nome = nome;
        this.endereco = endereco;
        this.credito = credito;
        this.debito = debito;
    }

    public Fornecedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDebito() {
        return debito;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor fornecedor = (Fornecedor) o;
        return id == fornecedor.id && Float.compare(credito, fornecedor.credito) == 0 && Float.compare(debito, fornecedor.debito) == 0 && Objects.equals(nome, fornecedor.nome) && Objects.equals(endereco, fornecedor.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, credito, debito);
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", credito=" + credito +
                ", debito=" + debito +
                '}';
    }
}
