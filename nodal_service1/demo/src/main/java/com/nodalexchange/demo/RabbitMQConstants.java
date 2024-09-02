package com.nodalexchange.demo;

public final class RabbitMQConstants {

    // Exchange name
    public static final String EXCHANGE_NAME = "nodalExchange";

    // Queue names
    public static final String QUEUE_NAME_SERVICE1 = "nodalService1Queue";
    public static final String QUEUE_NAME_SERVICE2 = "nodalService2Queue";

    // Routing keys
    public static final String ROUTING_KEY_SERVICE1 = "service1";
    public static final String ROUTING_KEY_SERVICE2 = "service2";

    // Messages
    public static final String MESSAGE_PING = "ping";
    public static final String MESSAGE_PONG = "pong";

    // Private constructor to prevent instantiation
    private RabbitMQConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
