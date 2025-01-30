package com.example.bookstore.repository.book;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationBuilder;
import com.example.bookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    public static final String AUTHOR_KEY = "author";
    public static final String TITLE_KEY = "title";
    public static final String ISBN_KEY = "isbn";
    @Autowired
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;
    @Autowired
    private final BookSearchParametersDto searchParameters;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> bookSpecification = Specification.where(null);
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            checkSpecificationParam(AUTHOR_KEY);
        }
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            checkSpecificationParam(TITLE_KEY);
        }
        if (searchParameters.isbns() != null && searchParameters.isbns().length > 0) {
            checkSpecificationParam(ISBN_KEY);
        }
        return bookSpecification;
    }

    private void checkSpecificationParam(String key) {
        Specification<Book> bookSpecification = Specification.where(null);
        bookSpecification
                .and(bookSpecificationProviderManager.getSpecificationProvider(key)
                        .getSpecification(searchParameters.authors()));
    }
}
