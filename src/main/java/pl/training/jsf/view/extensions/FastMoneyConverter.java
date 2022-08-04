package pl.training.jsf.view.extensions;

import org.javamoney.moneta.FastMoney;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(/*forClass = FastMoney.class,*/ managed = true, value = "pl.training.jsf.view.extensions.FastMoneyConverteras")
public class FastMoneyConverter implements Converter<FastMoney> {

    @Override
    public FastMoney getAsObject(FacesContext facesContext, UIComponent uiComponent, String text) {
        return FastMoney.parse(text);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, FastMoney fastMoney) {
        return fastMoney == null ? "0 PLN" : fastMoney.toString();
    }

}
