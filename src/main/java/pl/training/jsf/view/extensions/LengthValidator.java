package pl.training.jsf.view.extensions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {

    private int min;

    @Override
    public void initialize(Length constraintAnnotation) {
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
        return text != null && text.length() >= min;
    }

}
