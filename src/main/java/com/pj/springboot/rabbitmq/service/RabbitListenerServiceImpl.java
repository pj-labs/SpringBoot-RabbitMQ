package com.pj.springboot.rabbitmq.service;

import com.pj.springboot.rabbitmq.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Service class that handles receiving messages from RabbitMQ
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Slf4j
public class RabbitListenerServiceImpl implements RabbitListenerService {
    @RabbitListener(queues = "pres-rave-ws")
    public void onBookCreation(Book book) {
        log.info("Book received from RabbitMQ: {}", book);
    }
}
