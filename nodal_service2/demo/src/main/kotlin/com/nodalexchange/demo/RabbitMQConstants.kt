package com.nodalexchange.demo

object RabbitMQConstants {
    // Exchange name
    const val EXCHANGE_NAME = "nodalExchange"

    // Queue names
    const val QUEUE_NAME_SERVICE1 = "nodalService1Queue"
    const val QUEUE_NAME_SERVICE2 = "nodalService2Queue"

    // Routing keys
    const val ROUTING_KEY_SERVICE1 = "service1"
    const val ROUTING_KEY_SERVICE2 = "service2"

    // Messages
    const val MESSAGE_PING = "ping"
    const val MESSAGE_PONG = "pong"
}
