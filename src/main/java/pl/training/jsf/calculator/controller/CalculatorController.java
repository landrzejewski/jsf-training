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

    public ModelAndView selectOption(int option) {
        return switch (option) {
            case 1 -> new ModelAndView("AddValues");
            case 2 -> new ModelAndView("SubtractValues");
            case 3 -> new ModelAndView("Exit");
            default -> throw new IllegalArgumentException();
        };
    }

    public ModelAndView addValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.add(firstNumber, secondNumber);
        return new ModelAndView("Results", Map.of("result", result.toString()));
    }

    public ModelAndView subtractValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.subtract(firstNumber, secondNumber);
        return new ModelAndView("Results", Map.of("result", result.toString()));
    }

}
