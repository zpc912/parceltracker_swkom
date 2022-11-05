package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_transferwarehouse")
public class TransferwarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "regionGeoJson")
    @NotNull(message = "Region Geo Json cannot be null")
    @NotBlank(message = "Region Geo Json cannot be empty")
    private String regionGeoJson;

    @Column(name = "logisticsPartner")
    @NotNull(message = "Logistics Partner cannot be null")
    @NotBlank(message = "Logistics Partner cannot be empty")
    private String logisticsPartner;

    @Column(name = "logisticsPartnerUrl")
    @NotNull(message = "Logistics Partner Url cannot be null")
    @NotBlank(message = "Logistics Partner Url cannot be empty")
    private String logisticsPartnerUrl;
}
