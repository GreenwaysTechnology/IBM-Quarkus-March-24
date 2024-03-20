package org.acme;

import com.ibm.rest.client.HelloRestClientService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/welcome")
public class GreetingResource {

    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    //Get Vertx runtime
    @Inject
    Vertx vertx;

    //create WebClient object
    WebClient webClient;

    //life cylce method
    @PostConstruct
    public void init() {
        webClient = WebClient.create(vertx,
                new WebClientOptions().setDefaultHost("localhost").setDefaultPort(9000));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return helloRestClientService.sayHello();
    }

    //make api call using vertx webclient

    @GET
    @Path("webclient")
    public Uni<String> sayHello() {
        return webClient.get("/hello").send().onItem().transform(HttpResponse::bodyAsString);
    }


}
