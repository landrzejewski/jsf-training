package pl.training.jsf.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import lombok.extern.java.Log;

import java.util.Random;
import java.util.logging.Logger;

@Log
@ApplicationScoped
public class Providers {

    private final Random random = new Random();

    // @Singleton
    @RandomValue
    @Produces
    public int randomInt() {
        log.info("### Creating random int");
        return random.nextInt();
    }

    public void disposeRandomInt(@Disposes @RandomValue int randomInt, Logger logger) {
        logger.info("Disposing int: " + randomInt);
    }

    @RandomValue
    @Produces
    public String randomText(@RandomValue int randomInt) {
        return "Text" + randomInt;
    }

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
        var className = injectionPoint.getMember().getDeclaringClass().getName();
        return Logger.getLogger(className);
    }

}
