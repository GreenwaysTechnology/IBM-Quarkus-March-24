package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("hello")
@RegisterRestClient
public interface HelloRestClientService {
    //declare callee rest api specification
    @GET
    @Path("{id}")
    String sayHello();
//    @POST
//    Uni<Response> save(Book book);
}
