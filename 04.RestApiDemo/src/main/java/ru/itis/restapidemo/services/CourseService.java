package ru.itis.restapidemo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import ru.itis.restapidemo.dto.CourseDto;
import ru.itis.restapidemo.dto.TeacherDto;
import ru.itis.restapidemo.models.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course addCourse(CourseDto course);

    Course addTeacherIntoCourse(Long courseId, TeacherDto teacher);
}
