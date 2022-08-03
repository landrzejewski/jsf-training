package pl.training.jsf.decorators;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import lombok.Setter;
import pl.training.jsf.di.Car;
import pl.training.jsf.di.Vehicle;

import java.util.logging.Logger;

@Decorator
public abstract class SmartCar implements Vehicle {

    @Delegate
    @Inject
    @Setter
    private Car car;
    @Inject
    @Setter
    private Logger logger;

    @Override
    public void go() {
        logger.info("### Lights on");
        car.go();
    }

    public void stop() {
        logger.info("### Stopping...");
    }

}
