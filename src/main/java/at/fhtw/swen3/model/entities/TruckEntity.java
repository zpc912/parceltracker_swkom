package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "truck")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TruckEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String regionGeoJson;

    @Column
    private String numberPlate;
}
