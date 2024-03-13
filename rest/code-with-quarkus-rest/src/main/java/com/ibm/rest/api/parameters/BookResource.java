package com.ibm.rest.api.parameters;

import jakarta.ws.rs.*;

@Path("books")
public class BookResource {
    //path parameter
    //books/1 , /books/2 /books/3
    @GET
    @Path("{Id}")
    public String findById(@PathParam("Id") Long id) {
        return "Books By Id : " + id;
    }

    //Query Parameters
    //localhost:8080/books/pages?totalPages=10&unit=3
    @GET
    @Path("pages")
    public String getPages(@QueryParam("totalPages") @DefaultValue("2") Long pages, @QueryParam("unit") @DefaultValue("1") Long unit) {
        return "Total pages " + pages + " Unit " + unit;
    }

    //Matrix parameter

    @GET
    @Path("info")
    public String getBookInfo(@MatrixParam("category")  @DefaultValue("category") String category, @MatrixParam("lang") @DefaultValue("eng") String lang, @MatrixParam("author") @DefaultValue("author") String author) {
        return category + lang + author;
    }
}
