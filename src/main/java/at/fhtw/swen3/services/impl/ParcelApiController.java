package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.services.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-15T20:24:14.874537Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    private ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService) {
        this.parcelService = parcelService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel)
    {
        return ParcelApi.super.submitParcel(parcel);
    }
}
