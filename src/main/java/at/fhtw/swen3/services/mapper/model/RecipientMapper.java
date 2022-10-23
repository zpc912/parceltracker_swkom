package at.fhtw.swen3.services.mapper.model;

import at.fhtw.swen3.model.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.factory.Mappers;

public interface RecipientMapper {
    RecipientMapper INSTANCE = Mappers.getMapper(RecipientMapper.class);

    Recipient entityToDto(RecipientEntity recipientEntity);
    RecipientEntity dtoToEntity(Recipient recipient);
}
