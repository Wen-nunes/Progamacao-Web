package com.example.springjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 3)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
