package com.nodalexchange.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Declare a direct exchange using the constant and make it durable
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConstants.EXCHANGE_NAME, true, false);
    }

    // Declare nodalService1Queue and nodalService2Queue using constants and make them durable
    @Bean
    public Queue nodalService1Queue() {
        return new Queue(RabbitMQConstants.QUEUE_NAME_SERVICE1, true);
    }

    @Bean
    public Queue nodalService2Queue() {
        return new Queue(RabbitMQConstants.QUEUE_NAME_SERVICE2, true);
    }

    // Declare bindings between the exchange and the queues using constants
    @Bean
    public Binding bindingService1(Queue nodalService1Queue, DirectExchange directExchange) {
        return BindingBuilder.bind(nodalService1Queue).to(directExchange).with(RabbitMQConstants.ROUTING_KEY_SERVICE1);
    }

    @Bean
    public Binding bindingService2(Queue nodalService2Queue, DirectExchange directExchange) {
        return BindingBuilder.bind(nodalService2Queue).to(directExchange).with(RabbitMQConstants.ROUTING_KEY_SERVICE2);
    }
}
