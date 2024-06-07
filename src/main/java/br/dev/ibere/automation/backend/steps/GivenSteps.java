package br.dev.ibere.automation.backend.steps;

import br.dev.ibere.automation.backend.exception.AutomationException;
import br.dev.ibere.automation.backend.model.Product;
import br.dev.ibere.automation.backend.steps.basic.RestSteps;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;


@Slf4j
public class GivenSteps extends RestSteps {

    @Given("I create a {string} product")
    public void setNewProduct(String type) {
        switch (type) {
            case "new":
                log.info("Creating a new Product without id...");
                putInContext("newProduct", Product.builder()
                        .title("New product title")
                        .category("New category")
                        .price(new BigDecimal("99.99"))
                        .stock(50)
                        .build());
                break;
            case "updated":
                log.info("Creating a new Product with id...");
                putInContext("updatableProduct", Product.builder()
                        .id(1)
                        .title("Updated product title")
                        .category("Updated category")
                        .price(new BigDecimal("99.99"))
                        .stock(50)
                        .build());
                break;
            default:
                throw new AutomationException(
                        String.format("Cannot create a '%s' product, operation not valid.", type));
        }
    }

    @Given("I select product with id {int} to delete")
    public void selectProductToDelete(Integer id) {
        putInContext("idToDelete", id);
    }

}