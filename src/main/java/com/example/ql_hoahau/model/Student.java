package com.example.ql_hoahau.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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
    private String subject;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Clasz clasz;
}
