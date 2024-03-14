package com.ibm.cdi.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomeService {

    public String sayHello() {
        return "Hello";
    }
}
