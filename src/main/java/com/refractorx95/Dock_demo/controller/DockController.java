package com.refractorx95.Dock_demo.controller;

import com.refractorx95.Dock_demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/DockRefractoRX")
public class DockController {

    BookService bookService;

    p
    @GetMapping("/{bookId}")
    public ResponseEntity<String> getDock(@PathVariable String bookId){

        return new ResponseEntity<>("Book Found: " + bookId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllBooks(){
        List<String> books = new ArrayList();
        books.add("Java");
        books.add("MongoDB");
        books.add("Spring Boot");

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createBooks(String book){
        return new ResponseEntity<>("Book Created", HttpStatus.OK);
    }

    @PutMapping("/")
    public  ResponseEntity<String> updateBook(String book)
    {
        return new ResponseEntity<>("Book Updated",HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId)
    {
        return new ResponseEntity<>("Book deleted Successfully " + bookId,HttpStatus.OK);
    }
}
