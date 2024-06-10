package br.dev.ibere.automation.backend.steps.rest;

import br.dev.ibere.automation.backend.exception.AutomationException;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WhenSteps extends RestSteps {

    @When("I do stuff")
    public void doStuff() {
        log.info("doStuff");
    }

    @When("I request all {string} from Dummy JSON")
    public void requestAllItems(String searchItem) {
        log.info("Searching for all {}...", searchItem);
        switch (searchItem) {
            case "products":
                putInContext(searchItem, rest.getAllProducts());
                break;
            case "categories":
                putInContext(searchItem, rest.getAllCategories());
                break;
            case "categoriesList":
                putInContext(searchItem, rest.getAllCategoriesList());
                break;
            default:
                throw new AutomationException(String.format("Search item '%s' is not valid.", searchItem));
        }
    }

    @When("I send a request to {string} a product")
    public void manipulateProduct(String request) {
        log.info("Going to {} a product...", request);
        switch (request) {
            case "save":
                saveNewProduct();
                break;
            case "update":
                updateProduct();
                break;
            case "delete":
                deleteProduct();
                break;
            default:
                throw new AutomationException(String.format("Cannot '%s' a product, operation not valid.", request));
        }
    }

    private void saveNewProduct() {
        putInContext(
                "savedProduct",
                rest.createProduct(getFromContext("newProduct")));
    }

    private void updateProduct() {
        putInContext(
                "updatedProduct",
                rest.updateProduct(getFromContext("updatableProduct")));
    }

    private void deleteProduct() {
        putInContext(
                "deletedProduct",
                rest.deleteProduct(getFromContext("idToDelete")));
    }

}