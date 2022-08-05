package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.component.colorpicker.ColorPicker;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
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
    private LocalTime time = LocalTime.now();

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


    private String colorInline;
    private String colorPopup;

    public String getColorInline() {
        return colorInline;
    }

    public void setColorInline(String colorInline) {
        this.colorInline = colorInline;
    }

    public String getColorPopup() {
        return colorPopup;
    }

    public void setColorPopup(String colorPopup) {
        this.colorPopup = colorPopup;
    }

    public void onColorChange(AjaxBehaviorEvent e) {
        ColorPicker picker = (ColorPicker) e.getComponent();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Color changed: " + picker.getValue(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onPopupClosed(AjaxBehaviorEvent e) {
        ColorPicker picker = (ColorPicker) e.getComponent();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Popup closed: " + picker.getValue(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
