package com.ibm.vertx.event.bus;

import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

    //Listener method
    @ConsumeEvent("ibm.customer.service.list")
    public String findAll(String id) {
        return "Customer Service" + id;
    }
}