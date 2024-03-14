package com.ibm.cdi.service.lifecycles;

import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.List;

@ApplicationScoped
public class UserService {

    List list;

    @Startup
    public void init() {
        System.out.println("init method");
        list = List.of("Subramanian", "Admin", "Guest");
    }

    public Uni<List<String>> getUsers() {
        return Uni.createFrom().item(list);
    }

    @Shutdown
    public void destory() {
        //clean activity
    }

    public void start(@Observes StartupEvent startupEvent) {
        System.out.println("Startup event");
    }
}
