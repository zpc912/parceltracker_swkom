package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    private final Validator validator;
    private final ParcelRepository parcelRepository;
    private final RecipientRepository recipientRepository;

    public ParcelServiceImpl (Validator validator, ParcelRepository parcelRepository,RecipientRepository recipientRepository){
        this.validator = validator;
        this.parcelRepository = parcelRepository;
        this.recipientRepository = recipientRepository;
        log.info("create new Parcel Service Impl");
    }

    @Override
    public void submitNewParcel(ParcelEntity parcelEntity) {
        this.validator.validate(parcelEntity);
        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);
        log.info("newParcel submitted: "+ parcelEntity.toString());
    }

    @Override
    public void updateParcel(String id, ParcelEntity parcelEntity) {
        log.info("parcel updated from "+parcelRepository.findById(Long.parseLong(id))+" to ->" + parcelEntity.toString());
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void deleteParcel(String id) {

        log.info("parcel deleted -> "+parcelRepository.findById(Long.parseLong(id)));
        this.parcelRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<Parcel> getParcels() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = this.parcelRepository.findAll();
        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity));
        }
        log.info("return all parcels");
        return parcelDtos;
    }

}
