package org.example.booksrestclient.exceptions.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookISBNAlreadyExistException extends Exception {
    private String isbn;
}
