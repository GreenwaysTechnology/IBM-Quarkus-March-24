package com.ibm.rest.api.response;

import com.ibm.rest.api.entity.Product;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
public class ProductsResource {

    @GET
    public Response getProducts() {
        List<Product> products = List.of(new Product(12l, "Tooth Paste", 34.89));
        return Response.ok().header("mycompany","ibm").entity(products).build();
    }

    @DELETE
    public void remove(){
        System.out.println("Removed");
    }
    @POST
    public Response save(){
        return  Response.status(201).build();
    }
}
