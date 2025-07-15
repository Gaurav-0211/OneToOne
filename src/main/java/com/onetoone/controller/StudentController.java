package com.onetoone.controller;


import com.onetoone.dto.StudentDto;
import com.onetoone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable long id){
        StudentDto studentById = studentService.getUserById(id);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all-student")
    public ResponseEntity<Void> deleteAll(){
        studentService.deleteAllStudent();
        return ResponseEntity.noContent().build();
    }

}
