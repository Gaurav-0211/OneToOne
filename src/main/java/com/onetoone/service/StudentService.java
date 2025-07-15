package com.onetoone.service;


import com.onetoone.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudent();
    StudentDto getUserById(long id);
}
