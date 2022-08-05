package pl.training.jsf.view.extensions;

import lombok.Getter;
import lombok.Setter;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

@Getter
@Setter
@FacesComponent("inputLocalTime")
public class InputLocalTime extends UIInput implements NamingContainer {

    private static final List<String> HOURS = IntStream.rangeClosed(0, 23)
            .boxed()
            .map(InputLocalTime::pad)
            .collect(Collectors.toList());
    private static final List<String> MINUTES = IntStream.rangeClosed(0, 59)
            .boxed()
            .map(InputLocalTime::pad)
            .collect(Collectors.toList());

    private UIInput hour;
    private UIInput minute;

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        var localTime = (LocalTime) getValue();
        if (localTime != null) {
            hour.setValue(pad(localTime.getHour()));
            minute.setValue(pad(localTime.getMinute()));
        }
        super.encodeBegin(context);
    }

    @Override
    public Object getSubmittedValue() {
        var submittedHour = (String) hour.getSubmittedValue();
        var submittedMinutes = (String) minute.getSubmittedValue();
        if (submittedHour == null || submittedMinutes == null) {
            return null;
        } else {
            return submittedHour + ":" + submittedMinutes;
        }
    }

    @Override
    protected Object getConvertedValue(FacesContext context, Object newSubmittedValue) throws ConverterException {
        var submittedValue = (String) newSubmittedValue;
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            return LocalTime.parse(submittedValue, ISO_LOCAL_TIME);
        } catch (DateTimeParseException exception) {
            throw new ConverterException("Parse exception");
        }
    }

    private static String pad(Integer value) {
        return String.format("%02d", value);
    }

    public List<String> getHours() {
        return HOURS;
    }

    public List<String> getMinutes() {
        return MINUTES;
    }

}
