package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
@Setter
@Getter
public class UserContext implements Serializable {

    private String username;
    private Locale locale;
    private boolean isActive;

    @PostConstruct
    public void init() {
        var context = FacesContext.getCurrentInstance();
        locale = context.getApplication()
                .getViewHandler()
                .calculateLocale(context);
    }

}
