package org.example.booksrestclient.controllers;


import jakarta.validation.Valid;
import org.example.booksrestclient.dto.request.CreateBookRequest;
import org.example.booksrestclient.dto.request.UpdateBookRequest;
import org.example.booksrestclient.exceptions.exceptions.BookISBNAlreadyExistException;
import org.example.booksrestclient.exceptions.exceptions.BookNotFoundException;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity createBook(@Valid @RequestBody CreateBookRequest request) throws BookISBNAlreadyExistException {
        return bookService.createBook(request);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable("id") String id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(
            @PathVariable("id") String id,
            @Valid @RequestBody UpdateBookRequest request
    ) throws BookNotFoundException {
        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/status/{status}")
    public List<BookEntity> getBooksByStatus(@PathVariable("status") BookStatus status) {
        return bookService.getBooksByStatus(status);
    }
    @GetMapping("/book/{title}")
    public List<BookEntity> searchBooks(@PathVariable("title") String title) {
        return bookService.searchBooksByTitle(title);
    }
}


