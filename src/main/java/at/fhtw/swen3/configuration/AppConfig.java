package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.impl.ErrorServiceImpl;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ParcelServiceImpl parcelService(Validator validator, ParcelRepository parcelRepository, RecipientRepository recipientRepository) {
        return new ParcelServiceImpl(validator, parcelRepository, recipientRepository);
    }


    @Bean
    public ErrorServiceImpl errorService(ErrorRepository errorRepository) {
        return new ErrorServiceImpl(errorRepository);
    }
}
