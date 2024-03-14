package com.ibm.rest.api.reactive.mutiny;

import com.ibm.rest.api.entity.Product;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("reactive")
public class ReactiveReponseResource {

    @GET
    public Uni<List<Product>> getProductsAsync() {
        System.out.println(Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1l, "Tooth Paste", 1233.00),
                new Product(2l, "Too brush", 123.00),
                new Product(3l, "Shaving cream", 500.00),
                new Product(1l, "Soap", 340.00));
        return Uni.createFrom().item(products);
    }

    //response type
    @GET
    @Path("response")
    public Uni<Response> listProducts() {
        System.out.println(Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1l, "Tooth Paste", 1233.00),
                new Product(2l, "Too brush", 123.00),
                new Product(3l, "Shaving cream", 500.00),
                new Product(1l, "Soap", 340.00));

        return Uni.createFrom()
                .item(products)
                .onItem()
                .transform(products1 -> Response.ok(products1).header("message", "products"))
                .onItem()
                .transform(Response.ResponseBuilder::build);

    }
}
