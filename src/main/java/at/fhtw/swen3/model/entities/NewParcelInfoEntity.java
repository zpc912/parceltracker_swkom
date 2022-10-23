package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "newParcelInfo")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NewParcelInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String trackingId;
}
