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
import java.util.Optional;

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

    @Override
    public StudentDto getUserById(long id) {
        Optional<Student> byId = studentRepository.findById(id);

        Student student;
        if(byId.isPresent()){
            student = byId.get();
        }else{
            throw new RuntimeException("Student Not exist with id "+id);
        }
        StudentDto map = mapper.map(student, StudentDto.class);
        return map;
    }
}
