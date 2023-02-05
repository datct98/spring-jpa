package com.example.ql_hoahau.controller;

import com.example.ql_hoahau.model.Student;
import com.example.ql_hoahau.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/api/{nameClass}")
    public ResponseEntity<?> getClassByName(@PathVariable String nameClass) {
        return ResponseEntity.ok(classService.getLevelByName(nameClass));
    }
}
