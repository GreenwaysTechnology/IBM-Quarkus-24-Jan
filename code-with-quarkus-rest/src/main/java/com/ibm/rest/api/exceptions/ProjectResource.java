package com.ibm.rest.api.exceptions;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("project")
public class ProjectResource {

    @GET
    @Path("/{name}")
    public Response getProject(@PathParam("name") String name) {
        if (name.equals("quarkus")) {
            return Response.ok().entity("Quarkus").build();
        } else {
            // throw new RuntimeException("Project Not Found");
            throw new WebApplicationException("Project Not Found!!");
        }

    }

//    class ProjectNotFoundException extends RuntimeException {
//        public ProjectNotFoundException(String message) {
//            super(message);
//        }
//    }
}
