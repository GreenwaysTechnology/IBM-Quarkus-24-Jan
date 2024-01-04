package com.ibm.vertx.event.bus;

import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("notification")
public class NotificationResource {

    @Inject
    EventBus eventBus;

    @GET
    @Path("/{message}")
    public String publish(@PathParam("message") String message) {
        System.out.println(message);
        eventBus.publish("notification", message);
        return "published";
    }
}