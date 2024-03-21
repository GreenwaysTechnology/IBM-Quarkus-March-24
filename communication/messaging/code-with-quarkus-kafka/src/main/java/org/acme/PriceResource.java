package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.print.attribute.standard.Media;
import java.util.concurrent.CompletionStage;

@Path("prices")
public class PriceResource {

    @Inject
    @Channel("prices-out")
    Emitter<Double> priceEmiter;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String addPrice(Double price) {
        CompletionStage<Void> ack = priceEmiter.send(price);
        return "Published";
    }
}
