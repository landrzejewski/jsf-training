package pl.training.jsf.calculator.view;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.jsf.calculator.commons.View;
import pl.training.jsf.calculator.controller.CalculatorController;

import java.util.Map;
import java.util.Scanner;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SubtractValuesView implements View {

    private final CalculatorController controller;
    private final Scanner scanner;

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Odejmowanie:");
        System.out.println("Podaj pierwszą liczbę: ");
        var firstValue = scanner.nextBigDecimal();
        System.out.println("Podaj drugą liczbę: ");
        var secondValue = scanner.nextBigDecimal();
        controller.subtractValues(firstValue, secondValue);
    }

}
