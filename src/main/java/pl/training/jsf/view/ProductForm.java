package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.training.jsf.domain.Product;
import pl.training.jsf.domain.ProductCategory;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

@Getter
@Setter
@Named
@ViewScoped
public class ProductForm implements Serializable {

    private Product product = new Product();

    public Set<Entry<String, String>> categories() {
        return Arrays.stream(ProductCategory.values())
                .map(Enum::name)
                .collect(toMap(String::toLowerCase, category -> category))
                .entrySet();
    }

    public String save() {
        System.out.println(product);
        return "index?faces-redirect=true";
    }

}
