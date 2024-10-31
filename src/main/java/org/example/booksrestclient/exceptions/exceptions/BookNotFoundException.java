package org.example.booksrestclient.exceptions.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookNotFoundException extends Exception {
    private final String id;
}
