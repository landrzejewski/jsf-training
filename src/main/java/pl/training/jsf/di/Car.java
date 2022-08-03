package pl.training.jsf.di;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import lombok.extern.java.Log;

@Log
@Dependent
public class Car {

    private Engine engine;

    @Inject
    public Car(@Motor("petrol") Engine engine) {
        this.engine = engine;
    }

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
