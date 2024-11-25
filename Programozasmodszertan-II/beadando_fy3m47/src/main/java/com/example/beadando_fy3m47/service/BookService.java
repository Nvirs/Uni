package com.example.beadando_fy3m47.service;

import com.example.beadando_fy3m47.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book updatedBook);

    void deleteBook(Long id);

   
}
