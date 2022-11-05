package at.fhtw.swen3.persistence.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_hoparrival")
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "datetime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;

    //@Column(name = "visitedhop")
    //ManyToOne
    //@JoinColumn(name = "id_trackingInformation", nullable = false, updatable = false)
    //private TrackingInformationEntity visitedHop;

    //@Column(name = "futurehop")
    //@ManyToOne
    //@JoinColumn(name = "id_trackingInformation", nullable = false, updatable = false)
    //private TrackingInformationEntity futureHop;
}
