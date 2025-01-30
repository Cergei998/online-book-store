package com.example.bookstore.repository.book.spec;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;

public class IsbnSpecificationProvider implements SpecificationProvider<Book> {
    private static final String DTO_PARAMETER = "isbns";

    @Override
    public String getKey() {
        return "isbn";
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(DTO_PARAMETER)
                .in(Arrays.stream(params).toArray());
    }
}
