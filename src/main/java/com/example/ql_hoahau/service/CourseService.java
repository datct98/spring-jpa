package com.example.ql_hoahau.service;

import com.example.ql_hoahau.model.Course;
import com.example.ql_hoahau.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void insertCourse(Course course) {
        courseRepository.save(course);
    }

    public boolean updateCourse(Long id, Course newCourse) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return false;
        Course course = courseOptional.get();
        course.setName(newCourse.getName());
        course.setNumberOfLecture(newCourse.getNumberOfLecture());
        courseRepository.save(course);
        return true;
    }

    public boolean deleteCourse(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return false;
        courseRepository.delete(courseOptional.get());
        return true;
    }
}
