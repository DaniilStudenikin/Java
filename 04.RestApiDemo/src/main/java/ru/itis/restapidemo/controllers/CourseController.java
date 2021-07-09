package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.restapidemo.dto.CourseDto;
import ru.itis.restapidemo.dto.TeacherDto;
import ru.itis.restapidemo.models.Course;
import ru.itis.restapidemo.services.CourseService;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @PostMapping("/courses/{course_id}/teachers")
    public ResponseEntity<Course> addTeacherIntoCourse(@PathVariable("course_id") Long courseId,
                                                       @RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(courseService.addTeacherIntoCourse(courseId, teacher));
    }
}
