package com.pj.springboot.rabbitmq.service;

import com.pj.springboot.rabbitmq.domain.Book;

public interface RabbitMqService {
    /**
     * Send a Book message to RabbitMQ.
     *
     * @param book the Book to be sent
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    void sendBookMessage(Book book);
}
