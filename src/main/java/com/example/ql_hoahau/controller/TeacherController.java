package com.example.ql_hoahau.controller;

import com.example.ql_hoahau.model.Course;
import com.example.ql_hoahau.model.Teacher;
import com.example.ql_hoahau.service.CourseService;
import com.example.ql_hoahau.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/api/teachers")
    public ResponseEntity<?> getAllTeacher() {
        List<Teacher> teachers = teacherService.getAllTeacher();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/api/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertTeacher(@RequestBody Teacher teacher) {
        teacherService.insertTeacher(teacher);
    }

    @PutMapping("/api/teacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher newTeacher) {
        if (teacherService.updateTeacher(id, newTeacher))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("update success");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found teacher by " + id);
    }

    @DeleteMapping("/api/teacher/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        if (teacherService.deleteTeacher(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete success");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found teacher by " + id);
    }
}
