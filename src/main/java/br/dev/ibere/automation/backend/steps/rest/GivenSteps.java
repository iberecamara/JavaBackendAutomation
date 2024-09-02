package br.dev.ibere.automation.backend.steps.rest;

import br.dev.ibere.automation.backend.model.Product;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;


@Slf4j
public class GivenSteps extends RestSteps {

    @Given("I create a new product")
    public void createNewProduct() {
        log.info("Creating a new Product without id...");
        putInContext("newProduct", Product.builder()
                .title("New product title")
                .category("New category")
                .price(new BigDecimal("99.99"))
                .stock(50)
                .build());
    }

    @Given("I update a product")
    public void updateProduct() {
        Long itemId = 1L;
        log.info("Updating Product with id {}...", itemId);
        putInContext("updatableProduct", Product.builder()
                .id(itemId)
                .title("Updated product title")
                .category("Updated category")
                .price(new BigDecimal("99.99"))
                .stock(50)
                .build());
    }

    @Given("I select product with id {int} to delete")
    public void selectProductToDelete(Integer id) {
        putInContext("idToDelete", id);
    }

}