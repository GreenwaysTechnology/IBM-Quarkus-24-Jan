package com.ibm.vertx.event.bus;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificationService {

    @ConsumeEvent("notification")
    public void consume_one(Message<String> message) {
        System.out.println("Listener 1");
        System.out.println(message.body() + " " + message.address());
    }

    @ConsumeEvent("notification")
    public void consume_two(Message<String> message) {
        System.out.println("Listener 2");
        System.out.println(message.body() + " " + message.address());
    }

    @ConsumeEvent("notification")
    public void consume_three(Message<String> message) {
        System.out.println("Listener 3");
        System.out.println(message.body() + " " + message.address());
    }
}