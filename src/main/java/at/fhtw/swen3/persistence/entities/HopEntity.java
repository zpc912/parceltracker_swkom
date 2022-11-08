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

    @Column
    private String hopType;

    @Column(name = "code")
    @Pattern(regexp = "^[A-Za-zÄÖÜäöüß0-9\\s\\-]+$")
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @Column
    @OneToOne
    private GeoCoordinateEntity locationCoordinates;
}
