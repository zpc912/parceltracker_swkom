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

    @Column(name = "traveltimeMins")
    private Integer traveltimeMins;

    @Column(name = "hop")
    @OneToOne
    @JoinColumn(name = "id_hop")
    private HopEntity hop;
}
