package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.restapidemo.dto.TeacherDto;
import ru.itis.restapidemo.models.Teacher;
import ru.itis.restapidemo.models.repositories.TeachersRepository;

import java.util.List;

import static ru.itis.restapidemo.dto.TeacherDto.from;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public List<TeacherDto> getAllTeachers() {
        return from(teachersRepository.findAllByIsDeletedIsNull());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacher) {
        Teacher newTeacher = Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();
        teachersRepository.save(newTeacher);
        return from(newTeacher);
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto teacherDto) {
        Teacher teacherForUpdate = teachersRepository.findById(teacherId)
                .orElseThrow(IllegalArgumentException::new);
        teacherForUpdate.setFirstName(teacherDto.getFirstName());
        teacherForUpdate.setLastName(teacherDto.getLastName());
        teachersRepository.save(teacherForUpdate);
        return from(teacherForUpdate);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacherForDelete = teachersRepository.findById(teacherId)
                .orElseThrow(IllegalArgumentException::new);
        teacherForDelete.setIsDeleted(true);
        teachersRepository.save(teacherForDelete);
    }
}
