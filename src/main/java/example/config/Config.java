package example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class Config {

    @Bean
    public Properties jpaProperties(
            @Value("${spring.jpa.properties.hibernate.dialect}") final String hibernateDialect,
            @Value("${spring.jpa.show-sql}") final String showSql
    ) {
        return new Properties() {{
            put("hibernate.dialect", hibernateDialect);
            put("hibernate.show-sql", showSql);
        }};
    }
}
