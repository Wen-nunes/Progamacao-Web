package com.example.springjpa;

import jakarta.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String type;
    private String areaCode;

    @ManyToOne // muitos telefones para um unico usuario
    @JoinColumn(name = "user_id") // identificando o usuario
    private User user;
}
