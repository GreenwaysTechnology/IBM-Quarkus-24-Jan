package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Hello from default")
    String message;
    @ConfigProperty(name = "app.user.name", defaultValue = "fallback")
    String name;

    @GET
    public String sayHello() {
        return message + name;
    }
}
