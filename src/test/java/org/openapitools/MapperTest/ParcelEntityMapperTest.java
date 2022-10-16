package org.openapitools.MapperTest;

import at.fhtw.swen3.OpenApiGeneratorApplication;
import at.fhtw.swen3.persistence.*;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.mapper.ParcelEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParcelEntityMapperTest {

    @Test
    void DtoToEntityTest() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId("PYJRB4HZ6");

        TrackingInformation trackingInformation = new TrackingInformation();
        HopArrival visitedHops = new HopArrival();
        HopArrival futureHops = new HopArrival();
        TrackingInformation.StateEnum stateEnum = TrackingInformation.StateEnum.INTRANSPORT;
        trackingInformation.addVisitedHopsItem(visitedHops);
        trackingInformation.addFutureHopsItem(futureHops);
        trackingInformation.setState(stateEnum);

        Parcel parcel = new Parcel();
        Recipient recipient = new Recipient();
        recipient.setName("Max");
        recipient.setStreet("Landstraße 2a");
        recipient.setPostalCode("A-1220");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        Recipient sender = new Recipient();
        sender.setName("Martina");
        sender.setStreet("Mariahilfer Straße 120");
        sender.setPostalCode("A-1070");
        sender.setCity("Wien");
        sender.setCountry("Österreich");

        parcel.setRecipient(recipient);
        parcel.setSender(sender);
        parcel.setWeight(12.0f);

        ParcelEntity parcelEntity = ParcelEntityMapper.INSTANCE.DtoToEntity(newParcelInfo, trackingInformation, parcel);

        assertEquals("PYJRB4HZ6", parcelEntity.getTrackingId());
        assertNotNull(stateEnum);
        //assertEquals(recipient.getCity(), parcelEntity.getRecipientEntity().getCity());
        //assertEquals(sender.getCity(), parcelEntity.getSenderEntity().getCity());
        assertEquals(12.0f, parcelEntity.getWeight());
    }
}
