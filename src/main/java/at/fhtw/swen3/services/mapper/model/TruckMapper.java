package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    Truck entityToDto(TruckEntity truckEntity);
    TruckEntity dtoToEntity(Truck truck);
}
