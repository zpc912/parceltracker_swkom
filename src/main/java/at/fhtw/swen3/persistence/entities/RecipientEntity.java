package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_recipient")
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Column(name = "street")
    @NotNull(message = "Street cannot be null")
    @NotBlank(message = "Street cannot be empty")
    private String street;

    @Column(name = "postalCode")
    @NotNull(message = "Postal code cannot be null")
    @NotBlank(message = "Postal code cannot be empty")
    private String postalCode;

    @Column(name = "city")
    @NotNull(message = "City cannot be null")
    @NotBlank(message = "City cannot be empty")
    private String city;

    @Column(name = "country")
    @NotNull(message = "Country cannot be null")
    @NotBlank(message = "Country cannot be empty")
    private String country;
}
