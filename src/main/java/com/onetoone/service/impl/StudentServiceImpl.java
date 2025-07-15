package com.onetoone.service.impl;


import com.onetoone.dto.StudentDto;
import com.onetoone.model.Student;
import com.onetoone.repo.StudentRepository;
import com.onetoone.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        return mapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> mapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }
}
