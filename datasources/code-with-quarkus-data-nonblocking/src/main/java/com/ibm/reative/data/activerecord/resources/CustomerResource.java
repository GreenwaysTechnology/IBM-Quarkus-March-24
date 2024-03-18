package com.ibm.reative.data.activerecord.resources;

import com.ibm.reative.data.activerecord.Customer;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    @GET
    public Uni<List<Customer>> findAll() {
        return Customer.listAll();
    }

    @Path("{id}")
    @GET
    public Uni<Response> findById(@PathParam("id") Long id) {
        return Customer.findById(id).onItem().transform(entity -> {
            if (entity == null) {
                throw new WebApplicationException("Entity not Found");
            }
            return Response.ok(entity).build();
        });
    }

    @POST
    public Uni<Response> create(Customer customer) {
        //error handler
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("Customer Not Found");
        }
        return Panache.withTransaction(customer::persist)
                .replaceWith(Response.ok(customer).status(Response.Status.CREATED).build());
    }
}
