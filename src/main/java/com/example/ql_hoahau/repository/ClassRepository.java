package com.example.ql_hoahau.repository;

import com.example.ql_hoahau.model.Clasz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Clasz, Long> {
    Clasz findOneByName(String name);
}
