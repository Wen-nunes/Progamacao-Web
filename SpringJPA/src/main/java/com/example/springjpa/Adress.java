package com.example.springjpa;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {
   private String street;
   private String city;
   private String state;
   private String zipCode;
}
