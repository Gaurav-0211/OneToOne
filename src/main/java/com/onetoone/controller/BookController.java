package com.onetoone.controller;


import com.onetoone.dto.BookDto;
import com.onetoone.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    @GetMapping
    public List<BookDto> getAll(){
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable long id){
        BookDto bookById = bookService.getUserById(id);
        return new ResponseEntity<>(bookById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll(){
        bookService.deleteAllBook();
        return ResponseEntity.noContent().build();
    }


}
