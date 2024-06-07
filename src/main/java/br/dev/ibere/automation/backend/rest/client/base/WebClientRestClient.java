package br.dev.ibere.automation.backend.rest.client.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public abstract class WebClientRestClient extends BaseRestClient {

    protected final WebClient client = WebClient.builder()
            .codecs(config -> config.defaultCodecs().enableLoggingRequestDetails(true))
            .build();

}
