package br.dev.ibere.automation.backend.rest.client.product;

import br.dev.ibere.automation.backend.model.Product;
import br.dev.ibere.automation.backend.model.Products;
import br.dev.ibere.automation.backend.rest.client.base.WebClientRestClient;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.List;


public class WebClientProductRest extends WebClientRestClient implements ProductRest {

    @Override
    public List<Product> all() {
        return client.mutate()
                .baseUrl(config.getProductsUrl())
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Products.class)
                .block()
                .getProducts();
    }

    @Override
    public Product byId(Integer id) {
        return client.mutate()
                .baseUrl(config.getProductsUrl())
                .build()
                .get()
                .uri(builder -> builder.path("/{id}")
                        .build(id))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public List<Product> search(String searchTerm) {
        return client.mutate()
                .baseUrl(config.getSearchProductsUrl())
                .build()
                .get()
                .uri(builder -> builder.queryParam("q", searchTerm)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Products.class)
                .block()
                .getProducts();
    }

    @Override
    public List<Product> byCategory(String category) {
        return client.mutate()
                .baseUrl(config.getCategoryUrl())
                .build()
                .get()
                .uri(builder -> builder.path("/{category}")
                        .build(category))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Products.class)
                .block()
                .getProducts();
    }

    @Override
    public Product add(Product product) {
        return client.mutate()
                .baseUrl(config.getAddProductsUrl())
                .build()
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(product)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public Product update(Product product) {
        return client.mutate()
                .baseUrl(config.getProductsUrl())
                .build()
                .put()
                .uri(builder -> builder.path("/{id}").build(product.getId()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(product)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public Product delete(Integer id) {
        return client.mutate()
                .baseUrl(config.getProductsUrl())
                .build()
                .delete()
                .uri(builder -> builder.path("/{id}").build(id))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToMono(Product.class)
                .block();
    }
}
