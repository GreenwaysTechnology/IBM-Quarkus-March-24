package com.ibm.rest.api.threading;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("nonblockingthread")
public class NonBlockingThreadResource {

    //return Uni

    @GET
    public Uni<String> getName() {
        System.out.println(Thread.currentThread().getName());
        return Uni.createFrom().item("Subramanian");
    }
}
