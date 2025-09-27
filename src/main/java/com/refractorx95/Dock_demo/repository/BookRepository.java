package com.refractorx95.Dock_demo.repository;

import com.refractorx95.Dock_demo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {

    @Query{"{bookId : '?0'}"}
    Book findBookByBookId(String bookId);


}
