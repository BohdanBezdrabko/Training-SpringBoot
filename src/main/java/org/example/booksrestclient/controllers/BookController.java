package org.example.booksrestclient.controllers;


import jakarta.validation.Valid;
import org.example.booksrestclient.dto.request.CreateBookRequest;
import org.example.booksrestclient.dto.request.UpdateBookRequest;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.example.booksrestclient.services.BookService;
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
    public BookEntity createBook(@Valid @RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable("id") String id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/status/{status}")
    public BookEntity getBookByStatus(@PathVariable("status") BookStatus status) {
        return bookService.getBookByStatus(status);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
        return "Deleted: " + id;
    }

    @PutMapping("/{id}")
    public BookEntity updateBookById(@PathVariable("id") String id, @Valid @RequestBody UpdateBookRequest request) {
        return bookService.updateBook(id, request);
    }
}


