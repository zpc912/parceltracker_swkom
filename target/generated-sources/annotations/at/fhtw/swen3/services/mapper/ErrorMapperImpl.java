package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T03:21:53+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Red Hat, Inc.)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public Error entityToDto(ErrorEntity errorEntity) {
        if ( errorEntity == null ) {
            return null;
        }

        Error error = new Error();

        return error;
    }

    @Override
    public ErrorEntity dtoToEntity(at.fhtw.swen3.services.dto.Error error) {
        if ( error == null ) {
            return null;
        }

        ErrorEntity.ErrorEntityBuilder errorEntity = ErrorEntity.builder();

        errorEntity.errorMessage( error.getErrorMessage() );

        return errorEntity.build();
    }
}
