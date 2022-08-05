package pl.training.jsf.view;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class UserChangeListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent valueChangeEvent) throws AbortProcessingException {
        System.out.println(valueChangeEvent.getNewValue());
    }

}
