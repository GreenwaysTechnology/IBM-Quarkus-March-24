package com.ibm.falut.timeout;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TimeoutService {

    public List<String> getProduts() throws InterruptedException {
        Thread.sleep(500);
        return List.of("Product1", "Product 2");
    }
}
