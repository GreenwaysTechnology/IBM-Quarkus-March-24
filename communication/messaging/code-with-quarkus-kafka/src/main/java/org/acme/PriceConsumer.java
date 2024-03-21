package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PriceConsumer {

    private final Random random = new Random();

    @Incoming("prices-in")
    public void consume(double price) {
        System.out.println("Got From Kafka " + price);
    }

    //publish prices every
    @Outgoing("prices-out")
    public Multi<Double> generate() {
        // Build an infinite stream of random prices
        // It emits a price every second
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .map(x -> random.nextDouble());
    }

}
