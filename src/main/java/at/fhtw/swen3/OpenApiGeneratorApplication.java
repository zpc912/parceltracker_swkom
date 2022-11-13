package at.fhtw.swen3;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.impl.ErrorServiceImpl;
import com.fasterxml.jackson.databind.Module;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "at.fhtw.swen3.services" , "at.fhtw.swen3.configuration", "at.fhtw.swen3.persistence", "at.fhtw.swen3.controller"})
@Slf4j
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
        log.info("Starting up application");
        ErrorServiceImpl service = new ErrorServiceImpl();
        ErrorEntity errorEntity = ErrorEntity.builder().errorMessage("Error Msg").build();
        service.saveErrorEntity(errorEntity);
        System.out.println(service.listAllErrors());
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}