package org.example.booksrestclient.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.booksrestclient.dto.request.CreateBookRequest;
import org.example.booksrestclient.models.BookEntity;
import org.example.booksrestclient.models.BookStatus;
import org.example.booksrestclient.services.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    void shouldCreateBook() throws Exception {
        // Виправлено: Використання CreateBookRequest замість CreateBook
        CreateBookRequest request = new CreateBookRequest("Test Book", "Author", "123-456-789", new Date(), BookStatus.AVAILABLE);
        BookEntity createdBook = BookEntity.builder()
                .id("1")
                .title("Test Book")
                .author("Author")
                .isbn("123-456-789")
                .publishedDate(new Date())
                .status(BookStatus.AVAILABLE)
                .build();

        Mockito.when(bookService.createBook(any(CreateBookRequest.class))).thenReturn(createdBook);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Author"));
    }

    @Test
    void shouldGetAllBooks() throws Exception {
        List<BookEntity> books = Arrays.asList(
                BookEntity.builder().id("1").title("Book 1").author("Author 1").status(BookStatus.AVAILABLE).build(),
                BookEntity.builder().id("2").title("Book 2").author("Author 2").status(BookStatus.CHECKED_OUT).build()
        );

        Mockito.when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Book 1"))
                .andExpect(jsonPath("$[1].status").value("CHECKED_OUT"));
    }
}
