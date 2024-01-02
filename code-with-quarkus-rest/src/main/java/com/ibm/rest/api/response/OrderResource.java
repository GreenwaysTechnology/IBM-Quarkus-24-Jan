package com.ibm.rest.api.response;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("orders")
public class OrderResource {

    //Single Order- Order Object

    @GET
    @Produces(value = "application/json")
    public Order getSingleOrder() {
        Order order = new Order(1, "pending", 1000.334, "Contains electronics");
        return order;
    }

    //List of Orders
    @GET
    @Path("/list")
    @Produces(value = "application/json")
    public List<Order> listOrder() {
        return List.of(
                new Order(1, "pending", 1000.334, "Contains electronics"),
                new Order(2, "delivered", 455434.90, "Contains electronics"),
                new Order(3, "dispatched", 233434.4555, "Contains electronics"),
                new Order(4, "InTransit", 122323.89, "Contains electronics"),
                new Order(5, "pending", 7800.334, "Contains electronics")
        );
    }

}
