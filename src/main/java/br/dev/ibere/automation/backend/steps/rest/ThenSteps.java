package br.dev.ibere.automation.backend.steps.rest;

import br.dev.ibere.automation.backend.exception.AutomationException;
import br.dev.ibere.automation.backend.model.Product;
import br.dev.ibere.automation.backend.model.ProductCategory;
import br.dev.ibere.automation.backend.steps.basic.BaseSteps;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Slf4j
public class ThenSteps extends BaseSteps {

    @Then("I validate that the response is a collection of {string}")
    public void validateResponseObjectType(String type) {
        log.info("Validating that response objects are {}...", type);
        switch (type) {
            case "products":
                validateIsListOfProductType();
                break;
            case "categories":
                validateIsListOfCategoryType();
                break;
            case "categoriesList":
                validateIsListOfStringType();
                break;
            default:
                throw new AutomationException(String.format("Collection of type '%s' is not valid.", type));
        }
    }

    private void validateIsListOfProductType() {
        List<Product> products = getFromContext("products");
        assertThat("Response elements should match expected type.",
                products.get(0),
                instanceOf(Product.class));
    }

    private void validateIsListOfCategoryType() {
        List<ProductCategory> products = getFromContext("categories");
        assertThat("Response elements should match expected type.",
                products.get(0),
                instanceOf(ProductCategory.class));
    }

    private void validateIsListOfStringType() {
        List<String> products = getFromContext("categoriesList");
        assertThat("Response elements should match expected type.",
                products.get(0),
                instanceOf(String.class));
    }

    @Then("I receive the {string} product in the response body")
    public void validateProduct(String type) {
        log.info("Validating that a product was {}...", type);
        Product generatedProduct;
        Product retrievedProduct;
        switch (type) {
            case "deleted":
                retrievedProduct = getFromContext("deletedProduct");
                assertThat("Deleted product must have the field 'isDeleted'.",
                        retrievedProduct, hasProperty(("isDeleted")));
                assertThat("Deleted product isDeleted field must be true.",
                        retrievedProduct.getIsDeleted(), is(true));
                return;
            case "saved":
                generatedProduct = getFromContext("newProduct");
                retrievedProduct = getFromContext("savedProduct");
                assertThat("Saved product must have an id.",
                        retrievedProduct,
                        hasProperty("id"));
                break;
            case "updated":
                generatedProduct = getFromContext("updatableProduct");
                retrievedProduct = getFromContext("updatedProduct");
                assertThat("Updated product must match id.",
                        retrievedProduct.getId(), is(generatedProduct.getId()));
                break;
            default:
                throw new AutomationException(String.format("Collection oof type '%s' is not valid.", type));
        }
        assertThat("Product title should match.",
                retrievedProduct.getTitle(), is(generatedProduct.getTitle()));
        assertThat("Product category should match.",
                retrievedProduct.getCategory(), is(generatedProduct.getCategory()));
        assertThat("Product price should match.",
                retrievedProduct.getPrice(), is(generatedProduct.getPrice()));
    }

}