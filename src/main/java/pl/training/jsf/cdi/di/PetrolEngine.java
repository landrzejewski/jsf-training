package pl.training.jsf.cdi.di;

import jakarta.enterprise.context.Dependent;
import lombok.extern.java.Log;

@Log
@Motor("petrol")
@Dependent
public class PetrolEngine implements Engine {

    @Override
    public void start() {
        log.info("### Petrol engine started");
    }

}
