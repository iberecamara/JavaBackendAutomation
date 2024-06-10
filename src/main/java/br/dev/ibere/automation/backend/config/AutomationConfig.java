package br.dev.ibere.automation.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;


@Configuration
@EnableSpringConfigured
@PropertySource(value = {
        "classpath:config/urls.properties",
        "classpath:config/urls-${env}.properties",
}, ignoreResourceNotFound = true)
public class AutomationConfig {
}