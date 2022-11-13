package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.repositories.ErrorRepository;
import at.fhtw.swen3.services.ErrorService;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Configurable
public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorRepository errorRepository;

    //@Autowired
    //private ErrorMapper errorMapper;


    public void saveErrorEntity(ErrorEntity error){
        errorRepository.save(error);
    }

    public List<ErrorEntity> listAllErrors(){
        return errorRepository.findAll();
    }

    /*private void saveErrorDto(Error error){
        errorRepository.save(errorMapper.INSTANCE.dtoToEntity(error));
    }*/
}
