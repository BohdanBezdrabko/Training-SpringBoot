package org.example.booksrestclient.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.booksrestclient.annotations.null_or_not_blank.NullOrNotBlank;
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
}
