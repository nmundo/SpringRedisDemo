package com.nathan.securitydemo2.controller;

import com.nathan.securitydemo2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")  // Maps HTTP requests to /books path
public class BookController {

    @Autowired
    private BookRepository bookRepository;  // Injects the BookRepository

    @PostMapping  // Handles POST requests for adding a new book
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);  // Saves the book object to Redis
    }

    @GetMapping("/{id}")  // Handles GET requests for retrieving a book by ID
    public Book getBook(@PathVariable String id) {
        return bookRepository.findById(id).orElse(null);  // Retrieves the book from Redis
    }

    @DeleteMapping("/{id}")  // Handles DELETE requests for deleting a book by ID
    public void deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);  // Deletes the book from Redis
    }
}