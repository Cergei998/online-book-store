package com.example.bookstore.repository.book.spec;

import static com.example.bookstore.repository.book.BookSpecificationBuilder.AUTHOR_PARAMETER;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {

    @Override
    public String getKey() {
        return AUTHOR_PARAMETER;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(AUTHOR_PARAMETER)
                .in(Arrays.stream(params).toArray());
    }
}
