package com.ibm.rest.api.payload;

import com.ibm.rest.api.entity.Order;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("orders")
public class OrderResource {


    @Path("single")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getSingleOrder() {
        return new Order(1, "Pending", 34.56, "this is nice product");
    }

    @GET
    public List<Order> getOrders() {
        return List.of(
                new Order(1, "PENDING", 1000.45, "Electronics"),
                new Order(2, "CREATED", 444.4, "Electronics"),
                new Order(3, "DISPATCHED", 344.89, "Electronics"),
                new Order(4, "INTRANSIT", 3434.90, "Electronics"),
                new Order(5, "CANCELLED", 1000.45, "Electronics"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(Order order) {
        System.out.println(order);
        return "saved";
    }


}
