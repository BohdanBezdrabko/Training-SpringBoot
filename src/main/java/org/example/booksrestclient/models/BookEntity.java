package org.example.booksrestclient.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Date;

@Data
@Builder
@Document(collection = "books")
public class BookEntity {
    @Id
    private String id;

    private String title;

    private String author;

    private Date publishedDate;

    @Indexed(unique = true)
    private String isbn;

    private BookStatus status;
}
