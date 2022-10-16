package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.persistence.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelEntityMapper {
    ParcelEntityMapper INSTANCE = Mappers.getMapper(ParcelEntityMapper.class);

    ParcelEntity DtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel);
    TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel);
    NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel);
    Parcel entityToParcelDto(ParcelEntity parcel);
}