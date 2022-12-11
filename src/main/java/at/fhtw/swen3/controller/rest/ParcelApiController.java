package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.controller.rest.ParcelApi;
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
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-15T20:24:14.874537Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    private final ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService) {
        this.request = request;
        this.parcelService = parcelService;
        //this.warehouseService = warehouseService;
    }


    /*@Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel",
            produces = { "application/json" },
            consumes = { "application/json" }
    )


    @Override
    public ResponseEntity<Void> reportParcelHop(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
            @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$") @Parameter(name = "code", description = "The Code of the hop (Warehouse or Truck).", required = true) @PathVariable("code") String code
    ) {
        //TODO

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Void> reportParcelDelivery(
            @Pattern(regexp = "^[A-Z0-9]{9}$")
            @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true)
            @PathVariable("trackingId") String trackingId
    ) {

        // TODO

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        log.info("Mapping ParcelDto to ParcelEntity");
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null, null, parcel);
        parcelEntity.setTrackingId("PYJRB4HZ6"); // TODO: randomly generate tracking id
        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setVisitedHops(new ArrayList<>());

        log.info("Passing ParcelEntity to ParcelServiceImpl");
        NewParcelInfo newParcelInfo = parcelService.submitNewParcel(parcelEntity);

        return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<TrackingInformation> trackParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$")
            @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true)
            @PathVariable("trackingId") String trackingId
    ) {
        // TODO

        return new ResponseEntity<TrackingInformation>( HttpStatus.OK);
    }


    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$")
            @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true)
            @PathVariable("trackingId") String trackingId,
            @Parameter(name = "Parcel", description = "", required = true)
            @Valid @RequestBody Parcel parcel
    ) {
        // TODO
        //NewParcelInfo newParcelInfo = new NewParcelInfo();
        //newParcelInfo.setTrackingId("VYORB4HZ6");

        return new ResponseEntity<NewParcelInfo>(HttpStatus.OK);
    }*/
}
