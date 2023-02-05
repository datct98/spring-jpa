package com.example.ql_hoahau.service;

import com.example.ql_hoahau.model.MissQueen;
import com.example.ql_hoahau.repository.MissQueenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissQueenService {
    @Autowired
    private MissQueenRepo missQueenRepo;

    public List<MissQueen> getAllMissQueen() {
        return missQueenRepo.missQueenTallest();
    }

    public MissQueen getMissQueenById(Long Id) {
        Optional<MissQueen> missQueen = missQueenRepo.findById(Id);
        return missQueen.orElse(null);
    }
    public void createMissQueen(MissQueen missQueen){
        missQueenRepo.save(missQueen);
    }
}
