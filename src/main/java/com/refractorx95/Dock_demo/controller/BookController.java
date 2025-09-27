package com.refractorx95.Dock_demo.controller;

import com.refractorx95.Dock_demo.dto.BookDto;
import com.refractorx95.Dock_demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DockRefractoRX")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getDock(@PathVariable String bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> bookDtoList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto){
        BookDto bookDto1 = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @PutMapping("/")
    public  ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto)
    {
        BookDto bookDto1 = bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId)
    {
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book deleted Successfully " + bookId,HttpStatus.OK);
    }
}
