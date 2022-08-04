package pl.training.jsf.view.extensions;

import org.javamoney.moneta.FastMoney;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(managed = true, value = "pl.training.jsf.view.extensions.FastMoneyValidator")
public class FastMoneyValidator implements Validator<FastMoney> {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, FastMoney fastMoney) throws ValidatorException {
        if (fastMoney.isLessThan(1)) {
            throw new ValidatorException(new FacesMessage("Should be greater than zero"));
        }
    }

}
