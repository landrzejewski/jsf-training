package pl.training.jsf.calculator.model;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class Calculator {

    public BigDecimal add(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue);
    }

    public BigDecimal subtract(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue);
    }

}
