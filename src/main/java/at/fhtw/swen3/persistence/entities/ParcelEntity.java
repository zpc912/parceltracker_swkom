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

    @Column(name = "trackingId")
    @NotNull(message = "Tracking ID cannot be null")
    @NotBlank(message = "Tracking ID cannot be empty")
    private String trackingId;

    @Column(name = "weight")
    @DecimalMin("0.0")
    private Float weight;

    @Column(name = "recipient")
    @NotNull(message = "Recipient cannot be null")
    @ManyToOne
    @JoinColumn(name = "id_recipient")
    private RecipientEntity recipient;

    @Column(name = "sender")
    @NotNull(message = "Sender cannot be null")
    @ManyToOne
    @JoinColumn(name = "id_sender")
    private RecipientEntity sender;

    @Column(name = "state")
    @NotNull(message = "State cannot be null")
    private StateEnum state;

    @OneToMany
    @NotNull(message = "Visited Hops cannot be null")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany
    @NotNull(message = "Future Hops cannot be null")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
