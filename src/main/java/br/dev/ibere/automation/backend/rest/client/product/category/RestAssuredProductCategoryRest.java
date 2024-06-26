package br.dev.ibere.automation.backend.rest.client.product.category;

import br.dev.ibere.automation.backend.model.ProductCategory;
import br.dev.ibere.automation.backend.rest.client.base.RestAssuredRestClient;
import io.restassured.http.ContentType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.restassured.RestAssured.given;

@Component
@ConditionalOnProperty(prefix = "rest", name = "client", havingValue = "restassured")
public class RestAssuredProductCategoryRest extends RestAssuredRestClient implements ProductCategoryRest {

    @Override
    public List<ProductCategory> all() {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getCategoriesUrl())
                .get()
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", ProductCategory.class);
    }

    @Override
    public List<String> list() {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .baseUri(config.getCategoriesListUrl())
                .get()
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", String.class);
    }

}
