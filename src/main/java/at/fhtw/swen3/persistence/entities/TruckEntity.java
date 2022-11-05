package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_truck")
public class TruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "regionGeoJson")
    @NotNull(message = "Region Geo Json cannot be null")
    @NotBlank(message = "Region Geo Json cannot be empty")
    private String regionGeoJson;

    @Column(name = "numberPlate")
    @NotNull(message = "Number plate cannot be null")
    @NotBlank(message = "Number plate cannot be empty")
    private String numberPlate;
}
