package br.dev.ibere.automation.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
        "classpath:config/urls.properties",
        "classpath:config/urls-${env}.properties",
}, ignoreResourceNotFound = true)
public class AutomationConfig {
}
