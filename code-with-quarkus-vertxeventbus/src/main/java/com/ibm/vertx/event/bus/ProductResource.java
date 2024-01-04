package com.ibm.vertx.event.bus;

import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("products")
public class ProductResource {

    @Inject
    EventBus eventBus;

    @GET
    public String publishProduct() {
        JsonObject product = new JsonObject().put("id", 1).put("name", "Books");
        eventBus.requestAndForget("product.service", product);
        return "Processed";
    }
}