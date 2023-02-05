package com.example.ql_hoahau.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "miss_queen")
public class MissQueen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double height;
    private Double weight;
    private Date date;
    @OneToOne
    @JoinColumn
    private Student student;
}
