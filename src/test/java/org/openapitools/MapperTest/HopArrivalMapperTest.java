package org.openapitools.MapperTest;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;

public class HopArrivalMapperTest {

    @Test
    void entityToDtoTest() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("PYJRB4HZ6");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
    }


    @Test
    void dtoToEntityTest() {
        HopArrival hopArrival = new HopArrival();
        hopArrival.setCode("PYJRB4HZ6");
        hopArrival.setDescription("Warehouse 12-27");
        hopArrival.setDateTime(OffsetDateTime.now());

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }
}
