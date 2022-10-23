package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParcelEntity {

    // NewParcelInfo:
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    // TrackingInformation:
    @NotNull
    private TrackingInformation.StateEnum state;
    @Valid
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    @Valid
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    // Parcel:
    @NotNull
    private float weight;
    @Valid
    private RecipientEntity recipient;
    @Valid
    private RecipientEntity sender;
}
