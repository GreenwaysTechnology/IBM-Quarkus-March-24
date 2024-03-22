package com.ibm.falut.timeout;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.util.List;

@Path("timeout")
public class TimoutResource {
    @Inject
    TimeoutService timeoutService;

    @GET
    @Timeout(1000)
    @Fallback(fallbackMethod = "getProductsFromCache")
    public List<String> getProducts() throws InterruptedException {
        return timeoutService.getProduts();
    }

    public List<String> getProductsFromCache() throws InterruptedException {
        return List.of("Dummy Products");
    }
}
