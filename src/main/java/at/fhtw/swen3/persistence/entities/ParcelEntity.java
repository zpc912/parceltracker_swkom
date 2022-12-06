package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.enums.StateEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_parcel")
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    @Column
    @DecimalMin("0.0")
    private Float weight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_recipient")
    @NotNull(message = "Recipient cannot be null")
    private RecipientEntity recipient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_sender")
    @NotNull(message = "Sender cannot be null")
    private RecipientEntity sender;

    @Column
    private StateEnum state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_visited_hops")
    @NotNull(message = "Visited Hops cannot be null")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull(message = "Future Hops cannot be null")
    @JoinColumn(name = "fk_furture_hops")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
