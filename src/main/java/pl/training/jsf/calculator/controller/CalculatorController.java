package pl.training.jsf.calculator.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.jsf.calculator.commons.Controller;
import pl.training.jsf.calculator.commons.ModelAndView;
import pl.training.jsf.calculator.model.Calculator;

@Controller
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculatorController {

    private final Calculator calculator;

    public ModelAndView showMenu() {
        return new ModelAndView("Menu");
    }

}
