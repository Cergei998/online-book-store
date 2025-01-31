package com.example.bookstore.repository.book;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationBuilder;
import com.example.bookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    public static final String AUTHOR_PARAMETER = "author";
    public static final String ISBN_PARAMETER = "isbn";
    public static final String TITLE_PARAMETER = "title";
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> bookSpecification = Specification.where(null);
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            bookSpecification = bookSpecification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR_PARAMETER)
                            .getSpecification(searchParameters.authors()));
        }
        if (searchParameters.isbns() != null && searchParameters.isbns().length > 0) {
            bookSpecification = bookSpecification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(ISBN_PARAMETER)
                            .getSpecification(searchParameters.isbns()));
        }
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            bookSpecification = bookSpecification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(TITLE_PARAMETER)
                            .getSpecification(searchParameters.titles()));
        }
        return bookSpecification;
    }
}
