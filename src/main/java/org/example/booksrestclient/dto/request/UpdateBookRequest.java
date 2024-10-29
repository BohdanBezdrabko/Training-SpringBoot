package org.example.booksrestclient.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.booksrestclient.annotations.null_or_not_blank.NullOrNotBlank;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;

import java.util.Date;

@Data
public class UpdateBookRequest {
    @NullOrNotBlank
    private String title;

    private Date publishedDate;

    @NullOrNotBlank
    private String author;

    @NullOrNotBlank
    private String isbn;

    private BookStatus status;

    public BookEntity updateBookEntity(BookEntity bookEntity) {
        if (title != null) {
            bookEntity.setTitle(title);
        }
        if (author != null) {
            bookEntity.setAuthor(author);
        }
        if (publishedDate != null) {
            bookEntity.setPublishedDate(publishedDate);
        }
        if (isbn != null) {
            bookEntity.setIsbn(isbn);
        }
        if (status != null) {
            bookEntity.setStatus(status);
        }
        return bookEntity;
    }
}
