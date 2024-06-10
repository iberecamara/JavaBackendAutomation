package br.dev.ibere.automation.backend.steps.rest;

import br.dev.ibere.automation.backend.rest.service.RestService;
import br.dev.ibere.automation.backend.steps.basic.BaseSteps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestSteps extends BaseSteps {

    @Autowired
    protected RestService rest;

}
