package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.NewParcelInfoEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewParcelInfoMapper {
    NewParcelInfoMapper INSTANCE = Mappers.getMapper(NewParcelInfoMapper.class);

    NewParcelInfo entityToDto(NewParcelInfoEntity newParcelInfoEntity);
    NewParcelInfoEntity dtoToEntity(NewParcelInfo newParcelInfo);
}
