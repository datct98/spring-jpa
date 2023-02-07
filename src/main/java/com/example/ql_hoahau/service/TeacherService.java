package com.example.ql_hoahau.service;

import com.example.ql_hoahau.model.Teacher;
import com.example.ql_hoahau.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public void insertTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public boolean updateTeacher(Long id, Teacher newTeacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isEmpty()) return false;
        Teacher teacher = teacherOptional.get();
        teacher.setName(newTeacher.getName());
        teacher.setAccountNum(newTeacher.getAccountNum());
        teacherRepository.save(teacher);
        return true;
    }

    public boolean deleteTeacher(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isEmpty()) return false;
        teacherRepository.delete(teacherOptional.get());
        return true;
    }
}
