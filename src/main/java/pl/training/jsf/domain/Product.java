package pl.training.jsf.domain;

import lombok.Data;
import org.javamoney.moneta.FastMoney;
import pl.training.jsf.view.extensions.Base;
import pl.training.jsf.view.extensions.Extended;
import pl.training.jsf.view.extensions.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {

    private String uuid;
    @NotEmpty(groups = Base.class)
    @Pattern(regexp = "[a-z]+", groups = {Base.class, Extended.class})
    @Length(min = 3, groups = Extended.class)
    private String name;
    private String description;
    private boolean isActive;
    private ProductCategory category;
    private int quantity;
    //private BigDecimal price = BigDecimal.ZERO;
    private FastMoney price = FastMoney.of(0, "PLN");
    private Date created = new Date();

}
