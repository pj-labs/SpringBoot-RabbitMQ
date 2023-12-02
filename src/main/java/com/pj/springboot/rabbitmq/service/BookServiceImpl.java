package com.pj.springboot.rabbitmq.service;

import com.pj.springboot.rabbitmq.domain.Book;
import com.pj.springboot.rabbitmq.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class that handles CRUD operations for Books
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final RabbitMqService rabbitMqService;

    public BookServiceImpl(BookRepository bookRepository, RabbitMqService rabbitMqService) {
        this.bookRepository = bookRepository;
        this.rabbitMqService = rabbitMqService;
    }

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @param book the Book to be created
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Book saveAndFlush(Book book) {
        book = bookRepository.saveAndFlush(book);
        rabbitMqService.sendBookMessage(book);
        return book;
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @param isbn the isbn of the Book to be found
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
