package pl.training.jsf.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import pl.training.jsf.cdi.events.MessageProducer;

import java.util.logging.Logger;

@Log
@ApplicationScoped
public class TestBean {

    @RandomValue
    @Inject
    private int randomInt;
    @RandomValue
    @Inject
    private int otherRandomInt;
    @Inject
    private Logger logger;
    @Inject
    private MessageProducer messageProducer;

    public void test() {
        log.info("### Random value: " + randomInt);
        log.info("### Other random value: " + otherRandomInt);
        logger.info("### Logger name: " + logger.getName());
        messageProducer.send("Hello!!");
    }

}
