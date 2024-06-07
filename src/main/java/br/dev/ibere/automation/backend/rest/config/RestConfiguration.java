package br.dev.ibere.automation.backend.rest.config;

import br.dev.ibere.automation.backend.exception.AutomationException;
import br.dev.ibere.automation.backend.rest.client.product.ProductRest;
import br.dev.ibere.automation.backend.rest.client.product.RestAssuredProductRest;
import br.dev.ibere.automation.backend.rest.client.product.WebClientProductRest;
import br.dev.ibere.automation.backend.rest.client.product.category.ProductCategoryRest;
import br.dev.ibere.automation.backend.rest.client.product.category.RestAssuredProductCategoryRest;
import br.dev.ibere.automation.backend.rest.client.product.category.WebClientProductCategoryRest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
public class RestConfiguration {

    @Value("${products.url}")
    private String productsUrl;

    @Value("${add.products.url}")
    private String addProductsUrl;

    @Value("${search.products.url}")
    private String searchProductsUrl;

    @Value("${category.url}")
    private String categoryUrl;

    @Value("${categories.url}")
    private String categoriesUrl;

    @Value("${category.list.url}")
    private String categoriesListUrl;

    @Value("${rest.client}")
    private String restClient;

    @Bean
    ProductRest getProductRestClient() {
        log.info("Starting {} Product REST client.", restClient);
        return switch (restClient) {
            case "webclient" -> new WebClientProductRest();
            case "restassured" -> new RestAssuredProductRest();
            default -> throw new AutomationException(String.format("Rest client '%s' is not valid.", restClient));
        };
    }

    @Bean
    ProductCategoryRest getProductCategoryRestClient() {
        log.info("Starting {} Product Category REST client.", restClient);
        return switch (restClient) {
            case "webclient" -> new WebClientProductCategoryRest();
            case "restassured" -> new RestAssuredProductCategoryRest();
            default -> throw new AutomationException(String.format("Rest client '%s' is not valid.", restClient));
        };
    }

}
