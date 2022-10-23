package at.fhtw.swen3.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "error")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ErrorEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String errorMessage;
}
