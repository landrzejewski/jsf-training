package pl.training.jsf.view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class NavigationController {

    public String showProducts() {
        return "products";
    }

}
