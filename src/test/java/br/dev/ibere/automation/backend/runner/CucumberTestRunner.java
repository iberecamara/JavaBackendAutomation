package br.dev.ibere.automation.backend.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/resources/features",},
        glue = {"br.dev.ibere.automation.backend.steps",
                "br.dev.ibere.automation.backend.runner"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}

