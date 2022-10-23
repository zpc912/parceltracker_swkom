package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);

    /*Hop entityToDto(HopEntity hopEntity);
    HopEntity dtoToEntity(Hop hop);*/
}
