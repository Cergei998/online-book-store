package com.example.bookstore.repository.book.spec;

import static com.example.bookstore.repository.book.BookSpecificationBuilder.ISBN_PARAMETER;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;

public class IsbnSpecificationProvider implements SpecificationProvider<Book> {

    @Override
    public String getKey() {
        return ISBN_PARAMETER;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(ISBN_PARAMETER)
                .in(Arrays.stream(params).toArray());
    }
}
