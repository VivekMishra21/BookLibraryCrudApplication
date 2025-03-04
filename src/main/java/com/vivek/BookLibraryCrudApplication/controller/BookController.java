package com.vivek.BookLibraryCrudApplication.controller;


import com.vivek.BookLibraryCrudApplication.entity.Book;
import com.vivek.BookLibraryCrudApplication.service.BookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("allBook")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping("savedBook")
    public Book saveBook(@RequestBody Book book){
      return   bookService.saveBook(book);
    }

    @GetMapping("book/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);

    }

    @PutMapping("updateBook/{id}")
    public Book updateBook(@PathVariable Integer id,@RequestBody Book book){
        return bookService.update(id,book);
    }

    @DeleteMapping("deleteBook/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);

    }


}
