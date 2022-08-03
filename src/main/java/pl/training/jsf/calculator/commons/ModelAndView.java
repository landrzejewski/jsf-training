package pl.training.jsf.calculator.commons;

import java.util.Map;

import static java.util.Collections.emptyMap;

public record ModelAndView(String viewName, Map<String, String> data) {

    public ModelAndView(String viewName) {
        this(viewName, emptyMap());
    }

}
