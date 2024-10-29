package org.example.booksrestclient.services;

import org.example.booksrestclient.dto.request.CreateBookRequest;
import org.example.booksrestclient.dto.request.UpdateBookRequest;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.example.booksrestclient.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(CreateBookRequest request) {
        BookEntity book = BookEntity.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .publishedDate(request.getPublishedDate())
                .isbn(request.getIsbn())
                .status(request.getStatus())
                .build();
        return bookRepository.save(book);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getBookById(String Id) {
        return bookRepository.findById(Id).orElse(null);
    }

    public BookEntity getBookByStatus(BookStatus status) {
        return bookRepository.findByStatus(status);
    }

    public void deleteBookById(String Id) {
        bookRepository.deleteById(Id);
    }

    public BookEntity updateBook(String id, UpdateBookRequest request) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        if (request.getTitle() != null) {
            book.setTitle(request.getTitle());
        }
        if (request.getAuthor() != null) {
            book.setAuthor(request.getAuthor());
        }
        if (request.getPublishedDate() != null) {
            book.setPublishedDate(request.getPublishedDate());
        }
        if (request.getIsbn() != null) {
            book.setIsbn(request.getIsbn());
        }
        if (request.getStatus() != null) {
            book.setStatus(request.getStatus());
        }
        return bookRepository.save(book);
    }
}
