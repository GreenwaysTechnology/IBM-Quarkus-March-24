package com.ibm.cdi.service.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {
    @Inject
    NumberGenerator generator;

    @GET
    public String getIsbn(){
        return generator.generateISBNGenerator();
    }
}
