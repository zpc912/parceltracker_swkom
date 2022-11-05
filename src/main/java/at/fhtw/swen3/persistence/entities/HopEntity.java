package at.fhtw.swen3.persistence.entities;

import com.vividsolutions.jts.geom.Point;
import lombok.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Coordinates;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_hop")
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hopType")
    @NotNull(message = "HopType cannot be null")
    @NotBlank(message = "HopType cannot be empty")
    private String hopType;

    @Column(name = "code")
    @NotNull(message = "Code cannot be null")
    @NotBlank(message = "Code cannot be empty")
    private String code;

    @Column(name = "description")
    @NotNull(message = "Code cannot be null")
    @NotBlank(message = "Code cannot be empty")
    @Size(min = 1, max = 300)
    private String description;

    @Column(name = "processingDelayMins")
    @NotNull(message = "Processing Delay Mins cannot be null")
    @NotBlank(message = "Processing Delay Mins cannot be empty")
    @Min(0)
    private Integer processingDelayMins;

    @Column(name = "location")
    @NotNull(message = "Location name cannot be null")
    @NotBlank(message = "Location name cannot be empty")
    private String locationName;

    @Column(name = "locationCoordinates")
    @ManyToOne
    @JoinColumn(name = "id_locationCoordinates")
    private GeoCoordinateEntity locationCoordinates;
}
