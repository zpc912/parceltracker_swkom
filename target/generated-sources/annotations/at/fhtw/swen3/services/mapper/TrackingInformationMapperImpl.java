package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-23T22:53:22+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TrackingInformationMapperImpl implements TrackingInformationMapper {

    @Override
    public TrackingInformation entityToDto(TrackingInformationEntity trackingInformationEntity) {
        if ( trackingInformationEntity == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        trackingInformation.setState( stateEnumToStateEnum( trackingInformationEntity.getState() ) );
        trackingInformation.setVisitedHops( hopArrivalEntityListToHopArrivalList( trackingInformationEntity.getVisitedHops() ) );
        trackingInformation.setFutureHops( hopArrivalEntityListToHopArrivalList( trackingInformationEntity.getFutureHops() ) );

        return trackingInformation;
    }

    @Override
    public TrackingInformationEntity dtoToEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        TrackingInformationEntity trackingInformationEntity = new TrackingInformationEntity();

        trackingInformationEntity.setState( stateEnumToStateEnum1( trackingInformation.getState() ) );
        trackingInformationEntity.setVisitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
        trackingInformationEntity.setFutureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );

        return trackingInformationEntity;
    }

    protected TrackingInformation.StateEnum stateEnumToStateEnum(StateEnum stateEnum) {
        if ( stateEnum == null ) {
            return null;
        }

        TrackingInformation.StateEnum stateEnum1;

        switch ( stateEnum ) {
            case PICKUP: stateEnum1 = TrackingInformation.StateEnum.PICKUP;
            break;
            case INTRANSPORT: stateEnum1 = TrackingInformation.StateEnum.INTRANSPORT;
            break;
            case INTRUCKDELIVERY: stateEnum1 = TrackingInformation.StateEnum.INTRUCKDELIVERY;
            break;
            case TRANSFERRED: stateEnum1 = TrackingInformation.StateEnum.TRANSFERRED;
            break;
            case DELIVERED: stateEnum1 = TrackingInformation.StateEnum.DELIVERED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + stateEnum );
        }

        return stateEnum1;
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

    protected StateEnum stateEnumToStateEnum1(TrackingInformation.StateEnum stateEnum) {
        if ( stateEnum == null ) {
            return null;
        }

        StateEnum stateEnum1;

        switch ( stateEnum ) {
            case PICKUP: stateEnum1 = StateEnum.PICKUP;
            break;
            case INTRANSPORT: stateEnum1 = StateEnum.INTRANSPORT;
            break;
            case INTRUCKDELIVERY: stateEnum1 = StateEnum.INTRUCKDELIVERY;
            break;
            case TRANSFERRED: stateEnum1 = StateEnum.TRANSFERRED;
            break;
            case DELIVERED: stateEnum1 = StateEnum.DELIVERED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + stateEnum );
        }

        return stateEnum1;
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
}
