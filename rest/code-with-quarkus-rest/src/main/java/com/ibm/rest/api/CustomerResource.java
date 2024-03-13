package com.ibm.rest.api;

import jakarta.ws.rs.*;

@Path("customers")
public class CustomerResource {

    //api
    @GET
    public String findAll(){
        return  "FindAll";
    }

    @GET
    @Path("reviews")
    public String getReviews(){
        return "Reviews";
    }
    @POST
    public String create(){
        return  "Create";
    }
    @PUT
    public String update(){
        return  "Update";
    }

    @DELETE
    public String remove(){
        return  "Remove";
    }
}
