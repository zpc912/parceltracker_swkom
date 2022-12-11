package at.fhtw.swen3.services.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import javax.validation.*;
@Component
@Slf4j
public class MyValidator {
    private static MyValidator instance;

    private Validator myValidator;

    public static MyValidator getInstance(){
        if(instance == null)
            instance = new MyValidator();
        return instance;
    }

    private MyValidator(){
        myValidator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <T> void validate(T t){
        log.info("Validating " + t);
        Set<ConstraintViolation<T>> violations = myValidator.validate(t);
        violations.forEach(v -> log.error(v.getMessage()));

        if(!violations.isEmpty()){
            log.error("Validation error: " + violations);
            throw new ConstraintViolationException(violations);
        }
    }
}