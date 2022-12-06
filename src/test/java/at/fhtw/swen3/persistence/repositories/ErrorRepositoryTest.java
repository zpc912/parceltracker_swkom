package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //(classes={ErrorRepository.class})
public class ErrorRepositoryTest {
    @Autowired
    private ErrorRepository errorRepository;

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
        assertEquals(1, errorRepository.count());
    }
}
