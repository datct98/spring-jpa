package com.example.ql_hoahau.controller;

import com.example.ql_hoahau.model.MissQueen;
import com.example.ql_hoahau.service.MissQueenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MissQueenController {
    @Autowired
    private MissQueenService missQueenService;

    @GetMapping("/api/missqueens")
    public ResponseEntity<?> getAllMissQueen() {
        List<MissQueen> missQueenList = missQueenService.getAllMissQueen();
        return new ResponseEntity<>(missQueenList, HttpStatus.OK);
    }

    @GetMapping("/api/missqueen")
    public ResponseEntity<?> getMissQueenById(@RequestParam Long id) {
        if (missQueenService.getMissQueenById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(missQueenService.getMissQueenById(id), HttpStatus.OK);
    }

    @PostMapping("/api/missqueen")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMissQueen(@RequestBody MissQueen missQueen) {
        missQueenService.createMissQueen(missQueen);
    }
}
