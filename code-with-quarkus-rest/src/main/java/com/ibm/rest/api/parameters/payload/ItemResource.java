package com.ibm.rest.api.parameters.payload;

import com.ibm.rest.api.response.Product;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    @POST
    public Product save(Product product){
        System.out.println(product);
        return product;
    }
}
