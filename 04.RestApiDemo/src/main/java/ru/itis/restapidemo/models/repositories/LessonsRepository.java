package ru.itis.restapidemo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restapidemo.models.Lesson;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
