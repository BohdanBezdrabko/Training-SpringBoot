package org.example.booksrestclient.repository;

import ch.qos.logback.core.status.Status;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
    BookEntity findByStatus(BookStatus status);
}
