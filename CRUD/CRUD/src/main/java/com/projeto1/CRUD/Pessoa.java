package com.projeto1.CRUD;

import jakarta.persistence.*;

import java.security.Identity;
@Entity //Avisa para o JPA que Pessoa é uma entidade de um banco de dados
public class Pessoa {
    @Id //Esclare que é um atributo
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;
    @Column(nullable = false)//Especifica coluna não nula
    private String nome;
    @Column(nullable = false, unique = true)//Coluna de email nica e não nula
    private String email;
    @Column(nullable = false,length = 15)// Coluna não nula e com no maximo 15 caracteres
    private String fone;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String fone) {
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    public Pessoa(String fone, String email, int id, String nome) {
        this.fone = fone;
        this.email = email;
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }
}
