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
public class MenuView implements View {

    private final CalculatorController controller;
    private final Scanner scanner;

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Menu");
        System.out.println("1 - Dodaj");
        System.out.println("2 - Odejmij");
        System.out.println("3 - Wyjdź");
        var option = scanner.next();
        controller.select(option);
    }

}
