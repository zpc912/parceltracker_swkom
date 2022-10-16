package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T20:03:38+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient entityToDto(RecipientEntity recipientEntity) {
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

    @Override
    public RecipientEntity dtoToEntity(Recipient recipient) {
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
}
