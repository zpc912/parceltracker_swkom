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

    @Column
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    private String name;

    @Column
    @Pattern(regexp = "[A-Za-zÄÖÜäöüß]+\\s[0-9A-Za-zÄÖÜäöüß/\\s]+")
    private String street;

    @Column
    @Pattern(regexp = "^[AD]-\\d{4}$")
    private String postalCode;

    @Column
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    private String city;

    @Column
    private String country;

    public RecipientEntity name(String name) {
        this.name = name;
        return this;
    }

    public RecipientEntity street(String street) {
        this.street = street;
        return this;
    }

    public RecipientEntity postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public RecipientEntity city(String city) {
        this.city = city;
        return this;
    }

    public RecipientEntity country(String country) {
        this.country = country;
        return this;
    }
}
