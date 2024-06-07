package br.dev.ibere.automation.backend.rest.client.product;

import br.dev.ibere.automation.backend.model.Product;
import br.dev.ibere.automation.backend.model.Products;
import br.dev.ibere.automation.backend.rest.client.base.RestAssuredRestClient;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;


public class RestAssuredProductRest extends RestAssuredRestClient implements ProductRest {

    @Override
    public List<Product> all() {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getProductsUrl())
                .get()
                .as(Products.class)
                .getProducts();
    }

    @Override
    public Product byId(Integer id) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getProductsUrl())
                .basePath(String.valueOf(id))
                .get()
                .as(Product.class);
    }

    @Override
    public List<Product> search(String searchTerm) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getSearchProductsUrl())
                .param("q", searchTerm)
                .get()
                .as(Products.class)
                .getProducts();
    }

    @Override
    public List<Product> byCategory(String category) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getCategoryUrl())
                .basePath(category)
                .get()
                .as(Products.class)
                .getProducts();
    }

    @Override
    public Product add(Product product) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(config.getAddProductsUrl())
                .body(product)
                .post()
                .as(Product.class);
    }

    @Override
    public Product update(Product product) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(config.getProductsUrl())
                .basePath(String.valueOf(product.getId()))
                .body(product)
                .put()
                .as(Product.class);
    }

    @Override
    public Product delete(Integer id) {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getProductsUrl())
                .basePath(String.valueOf(id))
                .delete()
                .as(Product.class);
    }
}
