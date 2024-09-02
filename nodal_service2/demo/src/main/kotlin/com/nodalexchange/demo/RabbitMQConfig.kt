package com.nodalexchange.demo

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun nodalService1Queue(): Queue {
        return Queue(RabbitMQConstants.QUEUE_NAME_SERVICE1)
    }

    @Bean
    fun nodalService2Queue(): Queue {
        return Queue(RabbitMQConstants.QUEUE_NAME_SERVICE2)
    }

    @Bean
    fun exchange(): DirectExchange {
        return DirectExchange(RabbitMQConstants.EXCHANGE_NAME)
    }

    @Bean
    fun bindingService1Queue(nodalService1Queue: Queue, exchange: DirectExchange): Binding {
        return BindingBuilder.bind(nodalService1Queue).to(exchange).with(RabbitMQConstants.ROUTING_KEY_SERVICE1)
    }

    @Bean
    fun bindingService2Queue(nodalService2Queue: Queue, exchange: DirectExchange): Binding {
        return BindingBuilder.bind(nodalService2Queue).to(exchange).with(RabbitMQConstants.ROUTING_KEY_SERVICE2)
    }
}
