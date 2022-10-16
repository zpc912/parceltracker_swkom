package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T21:01:41+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelEntityMapperImpl implements ParcelEntityMapper {

    @Override
    public ParcelEntity DtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel) {
        if ( newParcelInfo == null && trackingInformation == null && parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        if ( newParcelInfo != null ) {
            parcelEntity.setTrackingId( newParcelInfo.getTrackingId() );
        }
        if ( trackingInformation != null ) {
            parcelEntity.setState( trackingInformation.getState() );
            parcelEntity.setFutureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );
            parcelEntity.setVisitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
        }
        if ( parcel != null ) {
            if ( parcel.getWeight() != null ) {
                parcelEntity.setWeight( parcel.getWeight() );
            }
            parcelEntity.setRecipient( recipientToRecipientEntity( parcel.getRecipient() ) );
            parcelEntity.setSender( recipientToRecipientEntity( parcel.getSender() ) );
        }

        return parcelEntity;
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

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setName( recipient.getName() );
        recipientEntity.setStreet( recipient.getStreet() );
        recipientEntity.setPostalCode( recipient.getPostalCode() );
        recipientEntity.setCity( recipient.getCity() );
        recipientEntity.setCountry( recipient.getCountry() );

        return recipientEntity;
    }

    protected HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        hopArrivalEntity.setCode( hopArrival.getCode() );
        hopArrivalEntity.setDescription( hopArrival.getDescription() );
        hopArrivalEntity.setDateTime( hopArrival.getDateTime() );

        return hopArrivalEntity;
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
