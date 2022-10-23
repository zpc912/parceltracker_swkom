package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "geoCoordinate")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GeoCoordinateEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Double lat;

    @Column
    private Double lon;
}
