package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
@Setter
@Getter
public class UserContext implements Serializable {

    private String username;
    private Locale currentLocale;
    private List<Locale> supportedLocales = new ArrayList<>();
    private boolean isActive;
    private LocalTime time;

    @PostConstruct
    public void init() {
        var facesContext = FacesContext.getCurrentInstance();
        var application =  facesContext.getApplication();
        currentLocale = application.getViewHandler()
                .calculateLocale(facesContext);
        supportedLocales.add(application.getDefaultLocale());
        application.getSupportedLocales()
                .forEachRemaining(supportedLocales::add);
    }

    public String getLanguageTag() {
        return currentLocale.toLanguageTag();
    }

    public void setLanguageTag(String languageTag) {
        currentLocale = Locale.forLanguageTag(languageTag);
    }

    public void reload() {
        FacesContext.getCurrentInstance()
                .getPartialViewContext()
                .getEvalScripts()
                .add("location.replace(location)");
    }

    public void userChanged(ValueChangeEvent event) {
        System.out.println(event.getNewValue());
    }

    public void updateTime() {
        System.out.println(time);
    }

}
