package com.ibm.rest.api.response;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public Response getProducts() {
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 48.00),
                new Product(2, "Tooth brush", 12.00),
                new Product(3, "Shaving cream", 60.00),
                new Product(4, "Soap", 34.00)

        );
        return Response.ok()
                .entity(products)
                .status(200)
                .header("company", "ebay").build();
    }
    @DELETE
    public void remove() {
        System.out.println("remove");
    }
}
