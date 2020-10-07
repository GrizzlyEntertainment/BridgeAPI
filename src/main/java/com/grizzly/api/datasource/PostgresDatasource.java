package com.grizzly.api.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Datasource processor for configuring the Hikari Datasource
 */
@Configuration
public class PostgresDatasource {

    /**
     * Registers the Hikari Data Source to be instantiated
     *  by the IoC container.
     * @return the hikari data source.
     */
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
