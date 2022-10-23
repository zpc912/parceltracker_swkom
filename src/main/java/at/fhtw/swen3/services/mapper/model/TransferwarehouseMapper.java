package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);

    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
}
