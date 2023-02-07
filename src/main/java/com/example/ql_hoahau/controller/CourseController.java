package com.example.ql_hoahau.controller;

import com.example.ql_hoahau.model.Course;
import com.example.ql_hoahau.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/api/courses")
    public ResponseEntity<?> getAllCourse() {
        List<Course> courseList = courseService.getAllCourse();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping("/api/course")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCourse(@RequestBody Course course) {
        courseService.insertCourse(course);
    }

    @PutMapping("/api/course/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course newCourse) {
        if (courseService.updateCourse(id, newCourse))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("update success");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found course by " + id);
    }

    @DeleteMapping("/api/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        if (courseService.deleteCourse(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete success");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found course by " + id);
    }
}
