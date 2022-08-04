package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.training.jsf.domain.InMemoryProductsService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class Products implements Serializable {

    @Inject
    @Setter
    private InMemoryProductsService productsService;
    @Getter
    @Setter
    private boolean isInEditMode;


    public List getAll() {
        return productsService.getAll();
    }

    public void deleteById(String id) {
        productsService.deleteById(id);
    }

    public void toggleEditMode() {
        isInEditMode = true;
    }

    public void save() {
        isInEditMode = false;
        getAll().forEach(System.out::println);
    }

}
