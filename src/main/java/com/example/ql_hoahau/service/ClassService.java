package com.example.ql_hoahau.service;

import com.example.ql_hoahau.model.Clasz;
import com.example.ql_hoahau.repository.ClassRepository;
import com.example.ql_hoahau.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Clasz getLevelByName(String name) {
        return classRepository.findOneByName(name);
    }
}
