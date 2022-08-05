package pl.training.jsf.view.extensions;

import org.javamoney.moneta.FastMoney;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

@FacesValidator(managed = true, value = "pl.training.jsf.view.extensions.FastMoneyValidator")
public class FastMoneyValidator implements Validator<FastMoney> {

    private static final String BUNDLE_KEY = "pl.training.jsf.view.extensions.FastMoneyValidator";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, FastMoney fastMoney) throws ValidatorException {
        if (fastMoney.isLessThan(1)) {
            var message = getMessage(facesContext, BUNDLE_KEY);
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public String getMessage(FacesContext context, String key) {
        return ResourceBundle.getBundle(context.getApplication().getMessageBundle(), context.getViewRoot().getLocale())
                .getString(key);
    }

}
