package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T03:21:54+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Red Hat, Inc.)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( truckEntity.getRegionGeoJson() );
        truck.setNumberPlate( truckEntity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck truck) {
        if ( truck == null ) {
            return null;
        }

        TruckEntity.TruckEntityBuilder truckEntity = TruckEntity.builder();

        truckEntity.regionGeoJson( truck.getRegionGeoJson() );
        truckEntity.numberPlate( truck.getNumberPlate() );

        return truckEntity.build();
    }
}
