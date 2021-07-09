package ru.itis.restapidemo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restapidemo.models.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {
}
