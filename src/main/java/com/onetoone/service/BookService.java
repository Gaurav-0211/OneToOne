package com.onetoone.service;



import com.onetoone.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto>  getAllBook();
    BookDto getUserById(long id);
    void deleteBook(long id);
    void deleteAllBook();
}
