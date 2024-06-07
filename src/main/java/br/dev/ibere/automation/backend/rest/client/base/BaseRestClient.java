package br.dev.ibere.automation.backend.rest.client.base;

import br.dev.ibere.automation.backend.rest.config.RestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRestClient {


    @Autowired
    protected RestConfiguration config;

}
