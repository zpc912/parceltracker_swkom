package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity);
    WarehouseEntity warehouseToWarehouseEntity(Warehouse warehouse);}
