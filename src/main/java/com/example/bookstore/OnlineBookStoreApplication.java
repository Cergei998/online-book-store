package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }
}
/*
GET: /api/books (Retrieve book catalog) (should be done in the previous PR)
GET: /api/books/{id} (Retrieve book details) (should be done in the previous PR)
POST: /api/books (Create a new book) (should be done in the previous PR)
PUT: /api/books/{id} (Update a specific book)
 */