package com.example.ql_hoahau.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double score;
    @Column(name = "subject",columnDefinition = "varchar(50) default 'java'")
    private String subject;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clasz_id")
    private Clasz clasz;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
