package at.fhtw.swen3.model.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity(name = "hopArrival")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"visitedHop", "futureHop"})
@EqualsAndHashCode(exclude = {"visitedHop", "futureHop"})
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;

    @Column
    @ManyToOne
    @JoinColumn(name = "fk_trackingInformation", nullable = false, updatable = false)
    private TrackingInformationEntity visitedHop;

    @Column
    @ManyToOne
    @JoinColumn(name = "fk_trackingInformation", nullable = false, updatable = false)
    private TrackingInformationEntity futureHop;
}
