package at.fhtw.swen3.model.entities;

import com.vividsolutions.jts.geom.Point;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "hop")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"locationCoordinates"})
@EqualsAndHashCode(exclude = {"locationCoordinates"})
public class HopEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    /*@Column
    @OneToOne
    @JoinColumn(name = "fk_locationCoordinates")
    private GeoCoordinateEntity locationCoordinates;*/
    @Column
    @Type(type="org.hibernate.spatial.GeometryType")
    @JoinColumn(name = "fk_locationCoordinates")
    private Point locationCoordinates;
}
