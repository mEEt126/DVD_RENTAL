package com.example.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Autowired
    Environment environment;

    private final String URL = "spring.datasource.url";
    private final String USER = "spring.datasource.username";
    private final String PASSWORD = "spring.datasource.password";
    private final String DRIVER = "spring.datasource.driver";

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(environment.getProperty(URL));
        hikariConfig.setDriverClassName(environment.getProperty(DRIVER));
        hikariConfig.setUsername(environment.getProperty(USER));
        hikariConfig.setPassword(environment.getProperty(PASSWORD));
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setMaximumPoolSize(10); // depends
        hikariConfig.setPoolName("Sample");
        hikariConfig.setConnectionTimeout(30000);
        hikariConfig.setMaxLifetime(2000000);
        hikariConfig.setIdleTimeout(30000);

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }
}
