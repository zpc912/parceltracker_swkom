package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "parcel")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"recipient", "sender"})
@EqualsAndHashCode(exclude = {"recipient", "sender"})
public class ParcelEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Float weight;

    @Column
    @OneToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;

    @Column
    @OneToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
}
