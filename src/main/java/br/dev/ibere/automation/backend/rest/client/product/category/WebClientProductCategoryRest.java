package br.dev.ibere.automation.backend.rest.client.product.category;

import br.dev.ibere.automation.backend.model.ProductCategory;
import br.dev.ibere.automation.backend.rest.client.base.WebClientRestClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@ConditionalOnProperty(prefix = "rest", name = "client", havingValue = "webclient")
public class WebClientProductCategoryRest extends WebClientRestClient implements ProductCategoryRest {

    @Override
    public List<ProductCategory> all() {
        return client.mutate()
                .baseUrl(config.getCategoriesUrl())
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToFlux(ProductCategory.class)
                .collectList()
                .block();
    }

    @Override
    public List<String> list() {
        return client.mutate()
                .baseUrl(config.getCategoriesListUrl())
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.empty())
                .bodyToFlux(String.class)
                .collectList()
                .block();
    }

}
