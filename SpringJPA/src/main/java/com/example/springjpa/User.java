package com.example.springjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Transient //uma coluna que eu evito que seja salva no banco de dados
    private String confirmPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // Um usuario para muitos telefones
    private List<Phone> phone;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile userProfile;
}
