package com.pj.springboot.rabbitmq.repository;

import com.pj.springboot.rabbitmq.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
