package at.fhtw.swen3.persistence.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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

    @Column
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;

    @Column
    @Pattern(regexp = "^[a-zA-ZßÄÖÜäöü/\\d \\-]*$")
    private String description;

    @Column
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