package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T20:40:50+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel) {
        if ( newParcelInfo == null && trackingInformation == null && parcel == null ) {
            return null;
        }

        ParcelEntity.ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        if ( newParcelInfo != null ) {
            parcelEntity.trackingId( newParcelInfo.getTrackingId() );
        }
        if ( trackingInformation != null ) {
            parcelEntity.state( trackingInformation.getState() );
            parcelEntity.visitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
            parcelEntity.futureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );
        }
        if ( parcel != null ) {
            parcelEntity.weight( parcel.getWeight() );
            parcelEntity.recipient( recipientToRecipientEntity( parcel.getRecipient() ) );
            parcelEntity.sender( recipientToRecipientEntity( parcel.getSender() ) );
        }

        return parcelEntity.build();
    }

    @Override
    public TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        trackingInformation.setState( parcel.getState() );
        trackingInformation.setVisitedHops( hopArrivalEntityListToHopArrivalList( parcel.getVisitedHops() ) );
        trackingInformation.setFutureHops( hopArrivalEntityListToHopArrivalList( parcel.getFutureHops() ) );

        return trackingInformation;
    }

    @Override
    public NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId( parcel.getTrackingId() );

        return newParcelInfo;
    }

    @Override
    public Parcel entityToParcelDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        Parcel parcel1 = new Parcel();

        parcel1.setWeight( parcel.getWeight() );
        parcel1.setRecipient( recipientEntityToRecipient( parcel.getRecipient() ) );
        parcel1.setSender( recipientEntityToRecipient( parcel.getSender() ) );

        return parcel1;
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity.RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }

    protected HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntity.HopArrivalEntityBuilder hopArrivalEntity = HopArrivalEntity.builder();

        hopArrivalEntity.code( hopArrival.getCode() );
        hopArrivalEntity.description( hopArrival.getDescription() );
        hopArrivalEntity.dateTime( hopArrival.getDateTime() );

        return hopArrivalEntity.build();
    }

    protected List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrivalEntity> list1 = new ArrayList<HopArrivalEntity>( list.size() );
        for ( HopArrival hopArrival : list ) {
            list1.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list1;
    }

    protected HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrival hopArrival = new HopArrival();

        hopArrival.setCode( hopArrivalEntity.getCode() );
        hopArrival.setDescription( hopArrivalEntity.getDescription() );
        hopArrival.setDateTime( hopArrivalEntity.getDateTime() );

        return hopArrival;
    }

    protected List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrival> list1 = new ArrayList<HopArrival>( list.size() );
        for ( HopArrivalEntity hopArrivalEntity : list ) {
            list1.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
        }

        return list1;
    }

    protected Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( recipientEntity.getName() );
        recipient.setStreet( recipientEntity.getStreet() );
        recipient.setPostalCode( recipientEntity.getPostalCode() );
        recipient.setCity( recipientEntity.getCity() );
        recipient.setCountry( recipientEntity.getCountry() );

        return recipient;
    }
}
