package br.dev.ibere.automation.backend.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.dev.ibere.automation.backend.database")
public class PersistenceConfig {
}
