package org.example.booksrestclient.controllers;


import jakarta.validation.Valid;
import org.example.booksrestclient.dto.request.CreateBookRequest;
import org.example.booksrestclient.dto.request.UpdateBookRequest;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.example.booksrestclient.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@Valid @RequestBody CreateBookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(request));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBook(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(
            @PathVariable("id") String id,
            @Valid @RequestBody UpdateBookRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<BookEntity>> getBooksByStatus(@PathVariable("status") BookStatus status) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByStatus(status));
    }
}


