package com.ibm.cdi.resources;

import com.ibm.cdi.service.GoodByService;
import com.ibm.cdi.service.WelcomeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("welcome")
public class WelcomeResource {

    @Inject
    WelcomeService welcomeService;
    @Inject
    GoodByService goodByService;

    @GET
    public String sayWelcome() {
        return welcomeService.sayHello() + " " + goodByService.sayGoodBye();
    }
}
