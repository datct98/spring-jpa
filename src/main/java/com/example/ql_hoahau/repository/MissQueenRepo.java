package com.example.ql_hoahau.repository;

import com.example.ql_hoahau.model.MissQueen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissQueenRepo extends JpaRepository<MissQueen, Long> {
    @Query(value = "select * from miss_queen where height > 50 LIMIT 1", nativeQuery = true) // nativeQuery
    List<MissQueen> missQueenTallest();

    List<MissQueen> findAllByNameOrHeight(String name, Double height);
}
