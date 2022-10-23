package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);

    /*WarehouseNextHops entityToDto(WarehouseNextHopsEntity warehouseNextHopsEntity);
    WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHops);*/
}
