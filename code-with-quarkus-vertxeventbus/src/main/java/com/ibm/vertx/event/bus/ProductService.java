package com.ibm.vertx.event.bus;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {

    @ConsumeEvent("product.service")
    public void process(Message<JsonObject> message) {
        System.out.println(message.body().encodePrettily());
        System.out.println(message.address());
    }
}