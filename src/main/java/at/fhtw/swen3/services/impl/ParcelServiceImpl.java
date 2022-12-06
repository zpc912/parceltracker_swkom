package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    private final Validator validator;
    private final ParcelRepository parcelRepository;
    private final RecipientRepository recipientRepository;


    /*@Override
    public NewParcelInfo submitNewParcel(ParcelEntity parcelEntity) {
        NewParcelInfo newParcelInfo = new NewParcelInfo();

        parcelEntity.setTrackingId("PYJRB4HZ6");
        log.info("Tracking ID for new Parcel: PYJRB4HZ6");

        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setVisitedHops(new ArrayList<>());

        this.validator.validate(parcelEntity);

        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);

        newParcelInfo = ParcelMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);
        log.info("New parcel submitted: " + parcelEntity);

        return newParcelInfo;
    }*/


    @Override
    public NewParcelInfo submitNewParcel(Parcel parcel) {
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null, null, parcel);
        parcelRepository.save(parcelEntity);
        log.info("New Parcel submitted");
    }


    @Override
    public List<Parcel> getAllParcels() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = this.parcelRepository.findAll();

        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity));
        }

        log.info("Get all parcels");
        return parcelDtos;
    }


    @Override
    public void updateParcel(Long id, ParcelEntity parcelEntity) {
        this.parcelRepository.save(parcelEntity);

        log.info("Parcel with ID " + parcelEntity.getId() + " updated: " + parcelEntity);
    }


    @Override
    public void deleteParcel(Long id) {
        this.parcelRepository.deleteById(id);

        log.info("Parcel with ID " + id + " deleted");
    }
}
