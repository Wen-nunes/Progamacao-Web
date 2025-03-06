package com.example.springjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identificador")
    private int id  ;
    private String nome;

    @ManyToMany
    @JoinTable(name = "student_course",
                joinColumns = @JoinColumn(name ="student_Id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}
