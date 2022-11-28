package at.fhtw.swen3;

import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.services.impl.ErrorServiceImpl;
import com.fasterxml.jackson.databind.Module;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools","at.fhtw.swen3", "at.fhtw.swen3.services", "at.fhtw.swen3.configuration", "at.fhtw.swen3.persistence"})//, "at.fhtw.swen3.controller"
//@EnableJpaRepositories(basePackages = "at.fhtw.swen3.persistence", repositoryBaseClass = ErrorRepository.class)
@Slf4j
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
        log.info("Starting up application ...");
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}