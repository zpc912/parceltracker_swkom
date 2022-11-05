package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);

    Hop entityToDto(HopEntity hopEntity);
    HopEntity dtoToEntity(Hop hop);

    /*@Mapping(source="hopEntity.hopType", target="hop.hopType")
    @Mapping(source="hopEntity.code", target="hop.code")
    @Mapping(source="hopEntity.description", target="hop.description")
    @Mapping(source="hopEntity.processingDelayMins", target="hop.processingDelayMins")
    @Mapping(source="hopEntity.locationName", target="hop.locationName")
    @Mapping(source="hopEntity.locationName")

    Hop entityToDto(HopEntity hopEntity);*/
}
