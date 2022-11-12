package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParcelService {
    void submitNewParcel(ParcelEntity parcelEntity);

    void updateParcel(String id, ParcelEntity parcelEntity);

    void deleteParcel(String id);

    List<Parcel> getParcels();
}
