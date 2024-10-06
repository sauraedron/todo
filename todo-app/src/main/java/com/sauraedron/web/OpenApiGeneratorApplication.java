package com.sauraedron.web;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {"com.sauraedron.web", "com.sauraedron" , "org.openapitools.configuration"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EnableJpaRepositories("com.sauraedron.repository")
@EntityScan("com.sauraedron.models.entities")
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean(name = "com.sauraedron.web.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}