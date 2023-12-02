package com.pj.springboot.rabbitmq.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Getter
@Setter
public class RabbitMqProperties {
    private String host;
    private String username;
    private String password;
    private String queue;
    private Template template;

    @Getter
    @Setter
    public static class Template {
        private String exchange;
        private String routingKey;
    }
}
