package com.ibm.activerecord.resources;

import com.ibm.activerecord.entity.Customer;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.List;

@Path("customers")
public class CustomerResource {

    @GET
    public List<Customer> findAll() {
        return Customer.listAll();
    }

    @GET
    @Path("{id}")
    public Customer findById(@PathParam("id") Integer id) {
        Customer customer = Customer.findById(id);
        if (customer == null) {
            throw new WebApplicationException("Customer with ID of " + id + "Not Found");
        }
        return customer;
    }

    //post
    @POST
    @Transactional
    public Response create(Customer customer) {
        if (customer.id != null) {
            throw new WebApplicationException("Id was invalid set On request");
        }
        customer.persist();
        return Response.ok(customer).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Customer update(@PathParam("id") Long id, Customer customer) {
        if (customer.name == null) {
            throw new WebApplicationException("Customer was not Supplied" + 422);
        }
        Customer customerEntity = Customer.findById(id);
        if (customerEntity == null) {
            throw new WebApplicationException("Customer was not Found" + 422);
        }
        //update logic: calling entity setter methods
        customerEntity.name = customer.name;
        customerEntity.city = customer.city;
        return customerEntity;
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Customer customer = Customer.findById(id);
        if (customer == null) {
            throw new WebApplicationException("Customer ID does not Exits");
        }
        customer.delete();
        return Response.status(204).build();
    }

}
