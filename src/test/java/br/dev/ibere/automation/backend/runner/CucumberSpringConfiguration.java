package br.dev.ibere.automation.backend.runner;

import br.dev.ibere.automation.backend.Automation;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(classes = Automation.class)
public class CucumberSpringConfiguration {
}
