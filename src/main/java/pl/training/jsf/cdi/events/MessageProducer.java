package pl.training.jsf.cdi.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.Setter;

@ApplicationScoped
public class MessageProducer {

    @Inject
    @Setter
    private Event<String> eventEmitter;

    public void send(String message) {
        eventEmitter.fire(message);
    }

}
