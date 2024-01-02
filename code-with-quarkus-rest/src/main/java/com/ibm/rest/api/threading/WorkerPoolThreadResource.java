package com.ibm.rest.api.threading;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("workerpoolthread")
public class WorkerPoolThreadResource {

    @GET
    public String getInfo() {
        String threadName = Thread.currentThread().getName();
        return threadName;
    }
}
