package com.example.empresajpa;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class LocalizacaoId implements Serializable {
    private String dlocal;
    private String dnumero;
}
