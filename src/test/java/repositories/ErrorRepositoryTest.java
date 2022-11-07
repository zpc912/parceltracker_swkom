package repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorRepositoryTest {
    @Autowired
    private ErrorRepository errorRepository;

    public ErrorEntity errorEntity;


    @BeforeEach
    void init() {
        errorRepository.deleteAll();
        errorEntity = ErrorEntity.builder()
                .errorMessage("An error occurred")
                .build();
    }


    @Test
    void saveNewErrorTest() {
        ErrorEntity errorEntity = ErrorEntity.builder()
                .errorMessage("An error occurred")
                .build();

        errorRepository.save(errorEntity);

        assertEquals(1, errorRepository.count());
    }
}
