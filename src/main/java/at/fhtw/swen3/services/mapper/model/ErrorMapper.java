package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper {
    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);

    Error entityToDto(ErrorEntity errorEntity);
    ErrorEntity dtoToEntity(Error error);
}
