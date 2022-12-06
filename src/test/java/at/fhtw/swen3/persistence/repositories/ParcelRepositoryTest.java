package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.dto.Parcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //(classes={ParcelRepository.class, RecipientRepository.class})
public class ParcelRepositoryTest {
    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    private ParcelEntity parcelEntity;
    private RecipientEntity recipient;
    private RecipientEntity sender;


    @BeforeEach
    void init() {
        //parcelRepository.deleteAll();
        //recipientRepository.deleteAll();

        List<HopArrivalEntity> visitedHops = new ArrayList<>();
        List<HopArrivalEntity> futureHops = new ArrayList<>();

        recipient = new RecipientEntity();
        recipient.setName("Max");
        recipient.setStreet("Mariahilfer Straße 120");
        recipient.setPostalCode("A-1070");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        sender = new RecipientEntity();
        sender.setName("Martina");
        sender.setStreet("Mariahilfer Straße 120");
        sender.setPostalCode("A-1070");
        sender.setCity("Wien");
        sender.setCountry("Österreich");

        parcelEntity = ParcelEntity.builder()
                .trackingId("A12006789")
                .visitedHops(visitedHops)
                .futureHops(futureHops)
                .recipient(recipient)
                .sender(sender)
                .state(StateEnum.INTRANSPORT)
                .weight(12.0f)
                .build();
    }


    @Test
    void saveTest() {
        parcelRepository.save(parcelEntity);
        assertEquals(1, parcelRepository.count());
    }
}
