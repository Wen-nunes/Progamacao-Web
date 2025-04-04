package com.example.apifinanceiro.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    private String nome;
    private String endereco;
    private float credito;
    private float debito;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

    public Cliente(int id, String nome, String endereco, float credito, float debito) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.credito = credito;
        this.debito = debito;
    }

    public Cliente(String nome, String endereco, float credito, float debito) {
        this.nome = nome;
        this.endereco = endereco;
        this.credito = credito;
        this.debito = debito;
    }

    public Cliente() {
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
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Float.compare(credito, cliente.credito) == 0 && Float.compare(debito, cliente.debito) == 0 && Objects.equals(nome, cliente.nome) && Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, credito, debito);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", credito=" + credito +
                ", debito=" + debito +
                '}';
    }
}
