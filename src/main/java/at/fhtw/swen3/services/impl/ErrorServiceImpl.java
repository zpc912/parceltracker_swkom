package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.services.ErrorService;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ErrorServiceImpl implements ErrorService {
    private final ErrorRepository errorRepository;


    @Override
    public void submitNewError(ErrorEntity errorEntity) {
        this.errorRepository.save(errorEntity);
        log.info("New Error submitted: " + errorEntity);
    }


    @Override
    public List<Error> getAllErrors() {
        List<Error> errorDtos = new ArrayList<>();
        List<ErrorEntity> errorEntities = this.errorRepository.findAll();

        for(ErrorEntity errorEntity : errorEntities) {
            errorDtos.add(ErrorMapper.INSTANCE.entityToDto(errorEntity));
        }

        log.info("Get all errors");
        return errorDtos;
    }


    @Override
    public void updateError(Long id, ErrorEntity errorEntity) {
        this.errorRepository.save(errorEntity);

        log.info("Error with ID " + id + " updated");
    }


    @Override
    public void deleteError(Long id) {
        this.errorRepository.deleteById(id);

        log.info("Error with ID " + id + " deleted");
    }
}
