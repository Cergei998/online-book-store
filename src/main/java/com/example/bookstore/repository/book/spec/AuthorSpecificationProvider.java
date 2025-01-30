package com.example.bookstore.repository.book.spec;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import static com.example.bookstore.repository.book.BookSpecificationBuilder.AUTHOR_KEY;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    private static final String DTO_PARAMETER = "authors";

    @Override
    public String getKey() {
        return AUTHOR_KEY;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(DTO_PARAMETER)
                .in(Arrays.stream(params).toArray());
    }
}
