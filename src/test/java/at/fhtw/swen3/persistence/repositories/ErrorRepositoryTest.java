package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.services.impl.ErrorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={ErrorRepository.class})
public class ErrorRepositoryTest {
    @Autowired
    private ErrorRepository errorRepository;

    //@Autowired
    //private ErrorServiceImpl errorService;

    private ErrorEntity errorEntity;


    @BeforeEach
    void init() {
        errorRepository.deleteAll();
        errorEntity = ErrorEntity.builder()
                .errorMessage("Test Error")
                .build();
    }


    @Test
    void saveNewErrorTest() {
        errorRepository.save(errorEntity);
        assertEquals(1, errorRepository.findAll().size());
    }
}
