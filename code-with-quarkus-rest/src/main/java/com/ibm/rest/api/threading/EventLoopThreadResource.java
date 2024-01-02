package com.ibm.rest.api.threading;

import com.ibm.rest.api.response.Product;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("reactive")
public class EventLoopThreadResource {

    @GET
    public Uni<String> getName() {
        String threadName = Thread.currentThread().getName();
        return Uni.createFrom().item("Subramanian is running on " + threadName);
    }

    @GET
    @Path("/products")
    public Uni<List<Product>> getProducts() {
        System.out.println("getProducts Thread =>  " + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Tooth brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00)

        );
        return Uni.createFrom().item(products);
    }

    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS) // or just @Produces
    public Multi<List<Product>> stream() {
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));

        return Multi.createFrom().items(products);
    }

    @GET
    @Path("/products/uniresponse")
    public Uni<Response> getProductsResponse() {
        System.out.println("getProductsResponse=>>" + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Tooth brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00)

        );
        return Uni.createFrom().item(products).onItem()
                .transform(f -> Response.ok(f).header("hello", "howare you"))
                .onItem().transform(Response.ResponseBuilder::build);
    }

}
