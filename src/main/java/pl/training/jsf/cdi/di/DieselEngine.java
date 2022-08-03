package pl.training.jsf.cdi.di;

import jakarta.enterprise.context.Dependent;
import lombok.extern.java.Log;

@Log
@Motor("diesel")
@Dependent
public class DieselEngine implements Engine {

    @Override
    public void start() {
        log.info("### Kleklekeke Diesel engine started");
    }

}
