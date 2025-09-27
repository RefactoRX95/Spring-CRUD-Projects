package com.refractorx95.Dock_demo.service;

import com.refractorx95.Dock_demo.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public  BookDto createBook(BookDto bookDto);

    public BookDto updateBookName(BookDto bookDto);

    public void deleteBookByBookId(String bookId);
}
