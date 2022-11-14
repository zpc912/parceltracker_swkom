package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ErrorService {

    void submitNewError(ErrorEntity errorEntity);

    List<Error> getAllErrors();

    void updateError(Long id, ErrorEntity errorEntity);

    void deleteError(Long id);
}
