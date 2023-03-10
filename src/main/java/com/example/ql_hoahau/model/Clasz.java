package com.example.ql_hoahau.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clasz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(columnDefinition = "varchar(50) default 'open'", nullable = false)
    private String status;

    @OneToMany(mappedBy = "clasz")
    private Set<Student> students;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    @JsonBackReference
    private Set<Teacher> teachers;
}
