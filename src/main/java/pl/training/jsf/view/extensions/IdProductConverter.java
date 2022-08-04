package pl.training.jsf.view.extensions;

import lombok.Setter;
import pl.training.jsf.domain.InMemoryProductsService;
import pl.training.jsf.domain.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class IdProductConverter implements Converter<Product> {

    @Inject
    @Setter
    private InMemoryProductsService productsService;

    @Override
    public Product getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        return productsService.getById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Product product) {
        return product.getUuid();
    }

}
