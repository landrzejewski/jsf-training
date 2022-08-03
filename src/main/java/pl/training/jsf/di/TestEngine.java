package pl.training.jsf.di;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import lombok.extern.java.Log;

@Log
@Alternative
@Motor("petrol")
@Dependent
public class TestEngine implements Engine {

    @Override
    public void start() {
        log.info("### Test engine started");
    }

}
