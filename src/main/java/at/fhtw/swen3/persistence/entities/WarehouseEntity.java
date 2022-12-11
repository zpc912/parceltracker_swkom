package at.fhtw.swen3.persistence.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_warehouse")
public class WarehouseEntity extends HopEntity {
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
