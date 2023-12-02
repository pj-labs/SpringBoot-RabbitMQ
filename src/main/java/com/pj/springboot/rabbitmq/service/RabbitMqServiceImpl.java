package com.pj.springboot.rabbitmq.service;

import com.pj.springboot.rabbitmq.domain.Book;
import com.pj.springboot.rabbitmq.properties.RabbitMqProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class that handles sending messages to RabbitMQ
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqProperties rabbitMqProperties;

    public RabbitMqServiceImpl(RabbitTemplate rabbitTemplate, RabbitMqProperties rabbitMqProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMqProperties = rabbitMqProperties;
    }

    /**
     * Send a Book message to RabbitMQ.
     *
     * @param book the Book to be sent
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public void sendBookMessage(Book book) {
        rabbitTemplate.convertAndSend(rabbitMqProperties.getExchange(), rabbitMqProperties.getRoutingKey(), book);
    }
}
