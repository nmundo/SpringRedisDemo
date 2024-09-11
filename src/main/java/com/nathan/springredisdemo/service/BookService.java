package com.nathan.securitydemo2.service;

import com.nathan.securitydemo2.model.Book;
import com.nathan.securitydemo2.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable(value = "books", key = "#id")  // Cache the result of this method
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }
}