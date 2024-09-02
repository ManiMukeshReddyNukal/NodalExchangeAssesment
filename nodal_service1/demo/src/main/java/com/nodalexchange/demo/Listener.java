package com.nodalexchange.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@EnableAsync
public class Listener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Listener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void sendInitialPing() {
        logger.info(" New Build created");
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_SERVICE2, RabbitMQConstants.MESSAGE_PING);
        logger.info("S1 sent initial '{}'", RabbitMQConstants.MESSAGE_PING);
    }

    @RabbitListener(queues = RabbitMQConstants.QUEUE_NAME_SERVICE1)
    public void listenMessages(String message) {
        logger.info("S1 Received message: {}", message);

        if (RabbitMQConstants.MESSAGE_PONG.equalsIgnoreCase(message)) {
            // Immediately send back a 'pong' message to the queue
            logger.info("Received '{}', sending 'pong' immediately", RabbitMQConstants.MESSAGE_PONG);
            sendPong();
        }

        // For both 'ping' and 'pong' messages, wait 10 seconds and then send a 'ping' message
        logger.info("Waiting for 10 seconds before sending 'ping'");
        waitAndSendPing();
    }

    private void sendPong() {
        logger.info("Sending '{}'", RabbitMQConstants.MESSAGE_PONG);
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_SERVICE2, RabbitMQConstants.MESSAGE_PONG);
    }

    @Async
    public void waitAndSendPing() {
        try {
            Thread.sleep(10000); // 10 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread interrupted", e);
        }
        logger.info("Sending '{}'", RabbitMQConstants.MESSAGE_PING);
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_SERVICE2, RabbitMQConstants.MESSAGE_PING);
    }
}
