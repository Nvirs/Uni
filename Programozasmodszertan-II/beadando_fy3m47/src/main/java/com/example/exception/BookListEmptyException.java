package com.example.exception;

public class BookListEmptyException extends RuntimeException {
    public BookListEmptyException(String message) {
        super(message);
    }
}
