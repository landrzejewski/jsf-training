package pl.training.jsf.cdi.di;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import pl.training.jsf.cdi.interceptors.LogExecutionTime;

@Log
@Dependent
public class Car implements Vehicle {

    private final Engine engine;

    @Inject
    public Car(@Motor("petrol") Engine engine) {
        this.engine = engine;
    }

    @LogExecutionTime
    @Override
    public void go() {
        engine.start();
        log.info("### Driving...");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("### Initializing car");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("### Destructing car");
    }

}
