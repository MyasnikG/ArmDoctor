package com.armdoctor.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource getDataSource(){
        return new DataSource();
    }

}
