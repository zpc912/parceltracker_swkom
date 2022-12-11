package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_warehousenexthops")
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @Column
    @ManyToOne
    @JoinColumn(name = "fk_warehouse")
    private HopEntity hop;

    @Column
    @ManyToOne
    @JoinColumn(name = "warehouse")
    private WarehouseEntity warehouse;
}
