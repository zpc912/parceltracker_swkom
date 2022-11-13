package repositories;

import at.fhtw.swen3.persistence.DatabaseConnection;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
public class DatabaseConnectionTest {
    @Autowired
    private ErrorRepository repo;
    @Test
    void createConnectionTest() {
        ErrorEntity err =  ErrorEntity.builder().errorMessage("ERROR!").build();
        repo.save(err);

        System.out.println(repo.findAll());
    }
}
