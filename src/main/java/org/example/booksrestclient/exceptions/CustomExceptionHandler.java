package org.example.booksrestclient.exceptions;

import org.example.booksrestclient.dto.response.ApiError;
import org.example.booksrestclient.exceptions.exceptions.BookISBNAlreadyExistException;
import org.example.booksrestclient.exceptions.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class, BookISBNAlreadyExistException.class})
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        if (ex instanceof BookNotFoundException exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiError("Book not found with id: " + exception.getId()));
        } else if (ex instanceof BookISBNAlreadyExistException exception) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT).body(new ApiError("Already Exist isbn:  " + exception.getIsbn()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError("Internal Server Error"));
        }

    }
}
