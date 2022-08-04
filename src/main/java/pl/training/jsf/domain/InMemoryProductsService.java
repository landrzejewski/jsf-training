package pl.training.jsf.domain;

import org.javamoney.moneta.FastMoney;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static pl.training.jsf.domain.ProductCategory.MOVIE;

@ApplicationScoped
public class InMemoryProductsService {

    private List<Product> products = List.of(
            new Product(UUID.randomUUID().toString(), "Rocky", "Film", true, MOVIE, 2, FastMoney.of(100, "PLN"), new Date()),
            new Product(UUID.randomUUID().toString(), "Alien", "Film", true, MOVIE, 3, FastMoney.of(100, "PLN"), new Date()),
            new Product(UUID.randomUUID().toString(), "Robocop", "Film", true, MOVIE, 1, FastMoney.of(100, "PLN"), new Date())
    );

    public List getAll() {
        return products;
    }

    public void deleteById(String id) {
        products = products.stream()
                .filter(product -> !product.getUuid().equals(id))
                .toList();
    }

    public Product getById(String id) {
        return products.stream()
                .filter(product -> !product.getUuid().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
