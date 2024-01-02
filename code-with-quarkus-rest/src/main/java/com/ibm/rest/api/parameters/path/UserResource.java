package com.ibm.rest.api.parameters.path;

import jakarta.ws.rs.*;

@Path("/users")
public class UserResource {

    @GET
    @Path("/{id}")
    public String findUserById(@PathParam("id") String id) {
        return id;
    }

    @PUT
    @Path("/{id}")
    public String updateUserById(@PathParam("id") String id) {
        return id;
    }

    @DELETE
    @Path("/{id}")
    public String removeUserById(@PathParam("id") String id) {
        return id;
    }
}
