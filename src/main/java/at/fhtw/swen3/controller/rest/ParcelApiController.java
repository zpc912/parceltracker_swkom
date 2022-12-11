package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-15T20:24:14.874537Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    @Autowired
    private final NativeWebRequest request;

    @Autowired
    private final ParcelService parcelService;

    public ParcelApiController(NativeWebRequest nativeWebRequest, ParcelService parcelService){
        this.request = nativeWebRequest;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId){
        log.info("reportParcelDelivery called.");

        if(parcelService.updateStatus(trackingId, StateEnum.DELIVERED).isPresent())
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code){
        log.info("reportParcelHop called.");

        parcelService.reportParcelHop();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel){
        log.info("submitParcel called.");

        try{
            Optional<NewParcelInfo> result = parcelService.createParcel(parcel);

            if(result.isPresent())
                return new ResponseEntity<>(result.get(), HttpStatus.CREATED);

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ConstraintViolationException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId){
        log.info("trackParcel called.");

        Optional<TrackingInformation> result = parcelService.getTrackingInformation(trackingId);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        log.info("transtionParcel called.");

        parcelService.transitionParcel(parcel);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}