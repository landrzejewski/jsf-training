package pl.training.jsf.calculator.view;

import jakarta.enterprise.context.ApplicationScoped;
import pl.training.jsf.calculator.commons.View;

import java.util.Map;

@ApplicationScoped
public class ExitView implements View {

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Calculator finished working");
    }

}
