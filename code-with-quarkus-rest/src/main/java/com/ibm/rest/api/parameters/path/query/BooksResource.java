package com.ibm.rest.api.parameters.path.query;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

//GET /books?pages=10
@Path("/books")
public class BooksResource {

    @GET
    public String getPages(@QueryParam("pages") @DefaultValue("1") Integer pages) {
        return "Requested Pages are " + pages;
    }
}