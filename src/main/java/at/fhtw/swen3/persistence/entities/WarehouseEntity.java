package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column
    private Integer level;

    @Column
    @OneToMany
    @JoinColumn(name = "fk_next_hops")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
