package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T19:00:12+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity) {
        if ( transferwarehouseEntity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setRegionGeoJson( transferwarehouseEntity.getRegionGeoJson() );
        transferwarehouse.setLogisticsPartner( transferwarehouseEntity.getLogisticsPartner() );
        transferwarehouse.setLogisticsPartnerUrl( transferwarehouseEntity.getLogisticsPartnerUrl() );

        return transferwarehouse;
    }

    @Override
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        TransferwarehouseEntity.TransferwarehouseEntityBuilder transferwarehouseEntity = TransferwarehouseEntity.builder();

        transferwarehouseEntity.regionGeoJson( transferwarehouse.getRegionGeoJson() );
        transferwarehouseEntity.logisticsPartner( transferwarehouse.getLogisticsPartner() );
        transferwarehouseEntity.logisticsPartnerUrl( transferwarehouse.getLogisticsPartnerUrl() );

        return transferwarehouseEntity.build();
    }
}
