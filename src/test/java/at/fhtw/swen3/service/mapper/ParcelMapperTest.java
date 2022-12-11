package at.fhtw.swen3.service.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParcelMapperTest {

    @Test
    void dtoToEntityTest() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId("PYJRB4HZ6");

        TrackingInformation trackingInformation = new TrackingInformation();
        HopArrival visitedHops = new HopArrival();
        HopArrival futureHops = new HopArrival();
        trackingInformation.setState(StateEnum.INTRANSPORT);
        trackingInformation.addVisitedHopsItem(visitedHops);
        trackingInformation.addFutureHopsItem(futureHops);

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

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(newParcelInfo, trackingInformation, parcel);

        assertNotNull(parcelEntity);
        assertEquals(newParcelInfo.getTrackingId(), parcelEntity.getTrackingId());
        assertNotNull(parcelEntity.getState());
        assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(12.0f, parcelEntity.getWeight());
    }


    @Test
    void entityToNewParcelInfoDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setTrackingId("PYJRB4HZ6");

        NewParcelInfo newParcelInfo = ParcelMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);

        assertEquals(parcelEntity.getTrackingId(), newParcelInfo.getTrackingId());
    }


    @Test
    void entityToTrackingInformationDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setState(StateEnum.INTRANSPORT);
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("PYJRB4HZ6");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        parcelEntity.getVisitedHops().add(hopArrivalEntity);
        parcelEntity.getFutureHops().add(hopArrivalEntity);

        TrackingInformation trackingInformation = ParcelMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);

        assertEquals(parcelEntity.getState(), trackingInformation.getState());
        assertEquals(parcelEntity.getVisitedHops().get(0).getCode(), trackingInformation.getVisitedHops().get(0).getCode());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDescription(), trackingInformation.getVisitedHops().get(0).getDescription());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDateTime(), trackingInformation.getVisitedHops().get(0).getDateTime());
    }


    @Test
    void entityToParcelDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setId(1l);
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

        List<HopArrivalEntity> visitedHops = new ArrayList<>();
        parcelEntity.setVisitedHops(visitedHops);

        List<HopArrivalEntity> futureHops = new ArrayList<>();
        parcelEntity.setFutureHops(futureHops);

        Parcel parcel = ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity);

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

    /*@Test
    void ValidationFalseTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        MyValidator validator = factory.getValidator();

        RecipientEntity recipient = new RecipientEntity();
        recipient.setName("Max");
        recipient.setStreet("Mariahilfer Straße 120");
        recipient.setPostalCode("A-1070");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(recipient);
        assertFalse(violations.isEmpty());
        assertEquals(recipient.getCity(), "Wien");
        assertEquals(recipient.getName(), "Max");
        assertEquals(recipient.getCountry(), "Österreich");
        assertEquals(recipient.getStreet(), "Mariahilfer Straße 120");
        assertEquals(recipient.getPostalCode(), "A-1070");
    }*/
}
