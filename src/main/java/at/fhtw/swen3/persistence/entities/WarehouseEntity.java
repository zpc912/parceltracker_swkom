package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_warehouse")
public class WarehouseEntity extends HopEntity {
    @Column
    private Integer level;


    @OneToMany
    @JoinColumn(name = "fk_next_hops")
    @Column
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
