package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "warehouse")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WarehouseEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Integer level;

    @Column
    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
