package com.example.bookstore.service.impl;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookDao;

    @Autowired
    public BookServiceImpl(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
