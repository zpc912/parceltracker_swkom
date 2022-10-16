package org.openapitools.MapperTest;

import at.fhtw.swen3.OpenApiGeneratorApplication;
import at.fhtw.swen3.persistence.*;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.mapper.ParcelEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


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

        assertNotNull(parcelEntity);
        assertEquals(newParcelInfo.getTrackingId(), parcelEntity.getTrackingId());
        assertNotNull(stateEnum);
        assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(12.0f, parcelEntity.getWeight());
    }


    @Test
    void entityToNewParcelInfoDto() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setTrackingId("PYJRB4HZ6");

        NewParcelInfo newParcelInfo = ParcelEntityMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);

        assertEquals(parcelEntity.getTrackingId(), newParcelInfo.getTrackingId());
    }


    @Test
    void entityToTrackingInformationDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setState(TrackingInformation.StateEnum.INTRANSPORT);
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("PYJRB4HZ6");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        parcelEntity.getVisitedHops().add(hopArrivalEntity);
        parcelEntity.getFutureHops().add(hopArrivalEntity);

        TrackingInformation trackingInformation = ParcelEntityMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);

        assertEquals(parcelEntity.getState(), trackingInformation.getState());
        assertEquals(parcelEntity.getVisitedHops().get(0).getCode(), trackingInformation.getVisitedHops().get(0).getCode());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDescription(), trackingInformation.getVisitedHops().get(0).getDescription());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDateTime(), trackingInformation.getVisitedHops().get(0).getDateTime());
    }


    @Test
    void entityToParcelDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setWeight(12.0f);
        RecipientEntity recipient = new RecipientEntity();
        recipient.setCity("Wien");
        recipient.setName("Max");
        recipient.setCountry("Österreich");
        recipient.setStreet("Mariahilfer Straße 120");
        recipient.setPostalCode("A-1070");
        RecipientEntity sender = new RecipientEntity();
        sender.setCity("Wien");
        sender.setName("Martina");
        sender.setCountry("Österreich");
        sender.setStreet("Landstraße 12a");
        sender.setPostalCode("A-1220");
        parcelEntity.setRecipient(recipient);
        parcelEntity.setSender(sender);

        Parcel parcel = ParcelEntityMapper.INSTANCE.entityToParcelDto(parcelEntity);

        assertEquals(parcelEntity.getWeight(), parcel.getWeight());
        assertEquals(parcelEntity.getRecipient().getCity(), parcel.getRecipient().getCity());
        assertEquals(parcelEntity.getRecipient().getName(), parcel.getRecipient().getName());
        assertEquals(parcelEntity.getRecipient().getCountry(), parcel.getRecipient().getCountry());
        assertEquals(parcelEntity.getRecipient().getStreet(), parcel.getRecipient().getStreet());
        assertEquals(parcelEntity.getRecipient().getPostalCode(), parcel.getRecipient().getPostalCode());
        assertEquals(parcelEntity.getSender().getCity(), parcel.getSender().getCity());
        assertEquals(parcelEntity.getSender().getName(), parcel.getSender().getName());
        assertEquals(parcelEntity.getSender().getCountry(), parcel.getSender().getCountry());
        assertEquals(parcelEntity.getSender().getStreet(), parcel.getSender().getStreet());
        assertEquals(parcelEntity.getSender().getPostalCode(), parcel.getSender().getPostalCode());
    }

    @Test
    void testValidationFalse() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        RecipientEntity recipient = new RecipientEntity();
        recipient.setCity("Wien");
        recipient.setName("Max");
        recipient.setCountry("Österreich");
        recipient.setStreet("Mariahilfer Straße 120");
        recipient.setPostalCode("A-1070");

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(recipient);
        assertFalse(violations.isEmpty());
        assertEquals(recipient.getCity(), "Wien");
        assertEquals(recipient.getName(), "Max");
        assertEquals(recipient.getCountry(), "Österreich");
        assertEquals(recipient.getStreet(), "Mariahilfer Straße 120");
        assertEquals(recipient.getPostalCode(), "A-1070");
    }
}
