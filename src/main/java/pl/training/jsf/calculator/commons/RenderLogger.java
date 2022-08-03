package pl.training.jsf.calculator.commons;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.extern.java.Log;

@ApplicationScoped
@Log
public class RenderLogger {

    public void onRender(@Observes ModelAndView modelAndView) {
        log.info("Rendering: %s".formatted(modelAndView.viewName()));
    }

}
