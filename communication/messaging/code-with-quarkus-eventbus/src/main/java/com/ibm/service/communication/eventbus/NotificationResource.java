package com.ibm.service.communication.eventbus;

import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("notification")
public class NotificationResource {

    @Inject
    EventBus eventBus;

    @GET
    @Path("{message}")
    public void publish(String message) {
        eventBus.<String>publish("notification", message);
    }
}
