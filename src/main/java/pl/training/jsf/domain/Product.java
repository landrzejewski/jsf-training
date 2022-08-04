package pl.training.jsf.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {

    private String uuid;
    private String name;
    private String description;
    private boolean isActive;
    private ProductCategory category;
    private int quantity;
    private BigDecimal price = BigDecimal.ZERO;
    private Date created = new Date();

}
