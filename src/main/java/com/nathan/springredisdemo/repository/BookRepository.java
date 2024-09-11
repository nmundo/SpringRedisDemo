package com.nathan.securitydemo2.repository;

import com.nathan.securitydemo2.model.Book;
import org.springframework.data.repository.CrudRepository;

public class BookRepository extends CrudRepository<Book, String> {
    public Optional<Book> findById(String id);
}
