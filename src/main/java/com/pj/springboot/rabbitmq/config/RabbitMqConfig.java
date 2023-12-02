package com.pj.springboot.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure all RabbitMq beans in this Configuration class
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Configuration
public class RabbitMqConfig {
    private final CachingConnectionFactory cachingConnectionFactory;

    public RabbitMqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    /**
     * Create Jackson2JsonMessageConverter bean
     *
     * @return Jackson2JsonMessageConverter bean
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Create RabbitTemplate bean and set its properties
     *
     * @return Created RabbitTemplate bean
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        var rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
