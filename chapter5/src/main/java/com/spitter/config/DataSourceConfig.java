package com.spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@ComponentScan({"com.spitter"})
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
//        dataSource.setUrl("jdbc:hsqldb:hsql://localhost/spitter/spitter");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create-db.sql")
                .addScript("db/insert-data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
