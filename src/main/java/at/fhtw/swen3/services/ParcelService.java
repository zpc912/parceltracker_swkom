package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParcelService {

    public Optional<Parcel> updateStatus(String trackingId, StateEnum state);

    public void reportParcelHop();

    public Optional<NewParcelInfo> createParcel(Parcel parcel);

    public Optional<TrackingInformation> getTrackingInformation(String trackingId);

    public void transitionParcel(Parcel parcel);
}