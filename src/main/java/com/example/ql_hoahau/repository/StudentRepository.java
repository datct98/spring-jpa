package com.example.ql_hoahau.repository;

import com.example.ql_hoahau.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByName(String name);

    List<Student> findAllByNameAndSubject(String name, String subject);

    List<Student> findAllByNameAndScore(String name, double score);

    List<Student> findAllByNameAndScoreAndAndSubject(String name, double score, String subject);
}
