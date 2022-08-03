package pl.training.jsf.calculator.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.jsf.calculator.commons.Controller;
import pl.training.jsf.calculator.commons.ModelAndView;
import pl.training.jsf.calculator.model.Calculator;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculatorController {

    private final Calculator calculator;

    public ModelAndView showMenu() {
        return new ModelAndView("Menu");
    }

    public ModelAndView select(String option) {
        return switch (option) {
            case "1" -> new ModelAndView("AddValues");
            case "2" -> new ModelAndView("SubtractValues");
            case "3" -> new ModelAndView("Exit");
            default -> throw new IllegalArgumentException();
        };
    }

    public ModelAndView addValues(BigDecimal firstValue, BigDecimal secondValue) {
        var result = calculator.add(firstValue, secondValue).toString();
        return new ModelAndView("Results", Map.of("result", result));
    }

    public ModelAndView subtractValues(BigDecimal firstValue, BigDecimal secondValue) {
        var result = calculator.subtract(firstValue, secondValue).toString();
        return new ModelAndView("Results", Map.of("result", result));
    }

}
