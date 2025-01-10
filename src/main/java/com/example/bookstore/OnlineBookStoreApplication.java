package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book peacefulWarrior = new Book();
            peacefulWarrior.setAuthor("Milman");
            peacefulWarrior.setTitle("Peaceful warrior");
            peacefulWarrior.setIsbn("xxx");
            peacefulWarrior.setPrice(BigDecimal.valueOf(999));
            bookService.save(peacefulWarrior);
        };
    }
}
