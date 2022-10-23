package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    /*Warehouse entityToDto(WarehouseEntity warehouseEntity);
    WarehouseEntity dtoToEntity(Warehouse warehouse);*/
}
