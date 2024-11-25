package com.example.beadando_fy3m47.controller;

import com.example.beadando_fy3m47.model.Book;
import com.example.beadando_fy3m47.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("listBooks", books);
        return "index";
    }

    @GetMapping("/new-book")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @GetMapping("/update-book/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book_form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, 
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "book_form";  // Make sure this matches your form template name
        }

        if (book.getId() == null) {
            bookService.createBook(book);
            redirectAttributes.addFlashAttribute("successMessage", "Könyv sikeresen hozzáadva a táblához!");
        } else {
            bookService.updateBook(book.getId(), book);
            redirectAttributes.addFlashAttribute("successMessage", "Könyv sikeresen módosítva!");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteBook(id);
        redirectAttributes.addFlashAttribute("successMessage", "Könyv sikeresen törölve a táblából!");
        return "redirect:/";
    }

   
}
