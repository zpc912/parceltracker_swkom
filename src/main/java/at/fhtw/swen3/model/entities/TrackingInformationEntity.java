package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "trackingInformation")
@Getter @Setter
@NoArgsConstructor
@ToString(exclude = {"visitedHops", "futureHops"})
@EqualsAndHashCode(exclude = {"visitedHops", "futureHops"})
public class TrackingInformationEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @Column
    @OneToMany(mappedBy = "visitedHop")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @Column
    @OneToMany(mappedBy = "futureHop")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
