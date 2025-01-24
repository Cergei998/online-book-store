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
/*
{
    "title": "Sample Book 2",
    "author": "Author B",
    "isbn": "9789876543210",
    "price": 24.99,
    "description": "Another sample book description.",
    "coverImage": "http://example.com/cover2.jpg"
}

 */
/*
{
    "title": "Sample Book 1",
    "author": "Author A",
    "isbn": "12389876543210",
    "price": 94.99,
    "description": "First sample book description.",
    "coverImage": "http://example.com/cover1.jpg"
}
 */
/*
{
    "id": 3,
    "title": "Sample Book 3",
    "author": "Author C",
    "isbn": "32489876543210",
    "price": 100.99,
    "description": "Third sample book description.",
    "coverImage": "http://example.com/cover3.jpg"
}
 */