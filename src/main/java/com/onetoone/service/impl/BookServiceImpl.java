package com.onetoone.service.impl;


import com.onetoone.dto.BookDto;
import com.onetoone.model.Book;
import com.onetoone.model.Student;
import com.onetoone.repo.BookRepository;
import com.onetoone.repo.StudentRepository;
import com.onetoone.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = mapper.map(bookDto, Book.class);

        Student student = book.getStudent();
        student.setBook(book);
        book.setStudent(student);

        studentRepository.save(student);
        Book savedBook = bookRepository.save(book);

        return mapper.map(savedBook, BookDto.class);
    }

    @Override
    public List<BookDto> getAllBook() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> mapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
}
