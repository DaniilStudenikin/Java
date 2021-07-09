package ru.itis.restapidemo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.restapidemo.dto.TeacherDto;
import ru.itis.restapidemo.services.TeacherService;

import java.util.List;

@RestController
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDto>> getTeacher() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @ApiOperation(value = "Добавление педагога")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = TeacherDto.class)})
    @PostMapping("/teachers")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(teacherService.addTeacher(teacher));
    }

    @PutMapping("/teachers/{teacher-id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("teacher-id") Long teacherId, @RequestBody TeacherDto teacherDto) {
        return ResponseEntity.ok(teacherService.updateTeacher(teacherId, teacherDto));
    }

    @DeleteMapping("/teachers/{teacher_id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("teacher_id") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok().build();
    }
}
