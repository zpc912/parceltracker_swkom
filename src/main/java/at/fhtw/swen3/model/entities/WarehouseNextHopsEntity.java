package at.fhtw.swen3.model.entities;

import at.fhtw.swen3.services.dto.Hop;
import lombok.*;

import javax.persistence.*;

@Entity(name = "warehouseNextHops")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WarehouseNextHopsEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Integer traveltimeMins;

    @Column
    @OneToOne
    @JoinColumn(name = "fk_hop")
    private HopEntity hop;

    @Column
    @ManyToOne
    @JoinColumn(name = "fk_warehouse")
    private WarehouseEntity warehouse;
}
