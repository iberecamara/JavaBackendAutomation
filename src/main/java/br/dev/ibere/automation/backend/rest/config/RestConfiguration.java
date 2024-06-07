package br.dev.ibere.automation.backend.rest.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

}
