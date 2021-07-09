package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.restapidemo.dto.CourseDto;
import ru.itis.restapidemo.dto.TeacherDto;
import ru.itis.restapidemo.models.Course;
import ru.itis.restapidemo.models.Teacher;
import ru.itis.restapidemo.models.repositories.CoursesRepository;
import ru.itis.restapidemo.models.repositories.TeachersRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Course addCourse(CourseDto course) {
        return coursesRepository.save(Course.builder()
                .title(course.getTitle())
                .build());
    }

    @Override
    public Course addTeacherIntoCourse(Long courseId, TeacherDto teacher) {
        Course course = coursesRepository.findById(courseId)
                .orElseThrow(IllegalArgumentException::new);
        Teacher teacherForCourse = teachersRepository.findById(teacher.getId())
                .orElseThrow(IllegalArgumentException::new);

        course.getTeachers().add(teacherForCourse);
        coursesRepository.save(course);
        return course;
    }
}
