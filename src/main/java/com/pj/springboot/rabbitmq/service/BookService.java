package com.pj.springboot.rabbitmq.service;

import com.pj.springboot.rabbitmq.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Book> findAll();

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book saveAndFlush(Book book);

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book findByIsbn(String isbn);
}
