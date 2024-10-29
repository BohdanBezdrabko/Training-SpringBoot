package org.example.booksrestclient.repository;

import ch.qos.logback.core.status.Status;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
   List<BookEntity> findAllByStatus(BookStatus status);
}
