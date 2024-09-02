package com.nodalexchange.demo

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
open class Listener(private val rabbitTemplate: RabbitTemplate) {

    private val logger: Logger = Logger.getLogger(Listener::class.java.name)

    @RabbitListener(queues = [RabbitMQConstants.QUEUE_NAME_SERVICE2])
    @Async // Make the method asynchronous
    open fun receiveMessage(message: String) {  // Make the method open for proxying
        logger.info("Received message: '$message' from ${RabbitMQConstants.QUEUE_NAME_SERVICE2}")

        when (message) {
            RabbitMQConstants.MESSAGE_PONG -> {
                logger.info("Received 'pong', sending 'pong' immediately")
                sendMessage(RabbitMQConstants.MESSAGE_PONG)
            }
            RabbitMQConstants.MESSAGE_PING -> {
                logger.info("Received 'ping', sending 'pong' immediately and waiting for 10 seconds before sending 'ping'")
                sendMessage(RabbitMQConstants.MESSAGE_PONG)
                Thread.sleep(10000)  // Simulate a delay of 10 seconds
                sendMessage(RabbitMQConstants.MESSAGE_PING)
            }
        }
    }

    private fun sendMessage(response: String) {
        logger.info("Sending message: '$response' to ${RabbitMQConstants.QUEUE_NAME_SERVICE1}")
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_SERVICE1, response)
    }
}
