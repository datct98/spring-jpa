package com.example.ql_hoahau.controller;

import com.example.ql_hoahau.model.Student;
import com.example.ql_hoahau.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @GetMapping("api/students")
    public ResponseEntity<?> getStudent(@RequestParam String name,
                                        @RequestParam(required = false) String subject,
                                        @RequestParam(required = false) Double score) {
        List<Student> studentList = studentService.findStudent(name, subject, score);
        if (studentList.size() == 0) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/api/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PatchMapping("api/add-student-to-class/{name-class}/{id}")
    public ResponseEntity<?> addStudentToClass(@PathVariable("id") Long idStudent,
                                               @PathVariable("name-class") String nameClass) {
        if (studentService.addStudentToClass(nameClass, idStudent))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found class or student");
    }

    @PutMapping("api/student/{id}")
    public ResponseEntity<String> updateScore(@PathVariable Long id,
                                              @RequestParam double score) {
        if (studentService.updateScore(id, score))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found class or student");
    }

    @DeleteMapping("api/remove-student/{name-class}/{id}")
    public ResponseEntity<String> removeStudentFromClass(@PathVariable("id") Long idStudent,
                                                         @PathVariable("name-class") String nameClass) {
        if (studentService.removeStudentFromClass(idStudent, nameClass))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found class or student");
    }
}
