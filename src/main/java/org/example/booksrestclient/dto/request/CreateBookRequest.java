package org.example.booksrestclient.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.booksrestclient.models.BookStatus;

import java.util.Date;
@Data
public class CreateBookRequest {
    @NotBlank
    private String title;

    private Date publishedDate;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;

    private BookStatus status;
}
