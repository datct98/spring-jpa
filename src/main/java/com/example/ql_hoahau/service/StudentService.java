package com.example.ql_hoahau.service;

import com.example.ql_hoahau.model.Clasz;
import com.example.ql_hoahau.model.Student;
import com.example.ql_hoahau.repository.ClassRepository;
import com.example.ql_hoahau.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    //
    public List<Student> findStudent(String name, String subject, Double score) {
        if (subject == null && score == null)
            return studentRepository.findAllByName(name);
        else if (score == null) {
            return studentRepository.findAllByNameAndSubject(name, subject);
        } else if (subject == null) {
            return studentRepository.findAllByNameAndScore(name, score);
        } else return studentRepository.findAllByNameAndScoreAndAndSubject(name, score, subject);
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public boolean addStudentToClass(String nameClass, Long idStudent) {
        Optional<Student> studentOptional = studentRepository.findById(idStudent);
        Clasz clasz = classRepository.findOneByName(nameClass);
        if (studentOptional.isEmpty() || clasz == null) return false;
        studentOptional.get().setClasz(clasz);
        studentRepository.save(studentOptional.get());
        return true;
    }

    public boolean updateScore(Long id, double newScore) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) return false;
        studentOptional.get().setScore(newScore);
        studentRepository.save(studentOptional.get());
        return true;
    }

    public boolean removeStudentFromClass(Long idStudent, String nameClass) {
        Optional<Student> studentOptional = studentRepository.findById(idStudent);
        Clasz clasz = classRepository.findOneByName(nameClass);
        if (studentOptional.isEmpty() || clasz == null) return false;
        studentOptional.get().setClasz(null);
        studentRepository.save(studentOptional.get());
        return true;
    }
}
