package pl.training.jsf.cdi.events;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.Setter;

import java.util.logging.Logger;

@Dependent
public class MessageConsumer {

    @Inject
    @Setter
    private Logger logger;

    public void onMessage(@Observes String message) {
        logger.info("### New message: " + message);
    }

}
