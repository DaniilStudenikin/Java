package ru.itis.restapidemo.services;

import ru.itis.restapidemo.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> getAllTeachers();

    TeacherDto addTeacher(TeacherDto teacher);

    TeacherDto updateTeacher(Long teacherId, TeacherDto teacherDto);

    void deleteTeacher(Long teacherId);
}
