package org.openapitools.MapperTest;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientMapperTest {

    @Test
    void entityToDto() {
        Recipient recipient = new Recipient();
        recipient.setName("Max");
        recipient.setPostalCode("A-1070");
        recipient.setCountry("Österreich");
        recipient.setStreet("Mariahilfer Straße 120");
        recipient.setCity("Wien");

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getCity(), recipientEntity.getCity());
    }


    @Test
    void dtoToEntity() {
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Max");
        recipientEntity.setPostalCode("A-1070");
        recipientEntity.setCountry("Österreich");
        recipientEntity.setStreet("Mariahilfer Straße 120");
        recipientEntity.setCity("Wien");

        Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        assertEquals(recipientEntity.getName(), recipient.getName());
        assertEquals(recipientEntity.getPostalCode(), recipient.getPostalCode());
        assertEquals(recipientEntity.getCountry(), recipient.getCountry());
        assertEquals(recipientEntity.getStreet(), recipient.getStreet());
        assertEquals(recipientEntity.getCity(), recipient.getCity());
    }
}
