package com.pj.springboot.rabbitmq.web;


import com.pj.springboot.rabbitmq.domain.Book;
import com.pj.springboot.rabbitmq.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides a REST API endpoints for the Book entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Book createNewBook() {
        Book book = new Book();
        book.setTitle("Spring Boot 2 Recipes");
        book.setIsbn("978-1-4842-3925-4");
        book.setEdition(1);
        book.setYearOfPublication(2018);
        book.setPublisher("OReilly Media");
        return bookService.saveAndFlush(book);
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update")
    public Book updateBook() {
        var book = bookService.findByIsbn("978-1-4842-3925-4");
        book.setTitle("Spring Boot 3 Recipes");
        book.setEdition(2);
        book.setYearOfPublication(2019);
        book.setPublisher("Personal Publication");
        return bookService.saveAndFlush(book);
    }
}
