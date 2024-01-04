package com.ibm.vertx.event.bus;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("customers")
public class CustomerResource {

    @Inject
    EventBus eventBus;

    @GET
    @Path("{id}")
    public Uni<String> getCustomerInfo(@PathParam("id") String id) {
        return eventBus.<String>request("ibm.customer.service.list", id).onItem().transform(Message::body);
    }
}