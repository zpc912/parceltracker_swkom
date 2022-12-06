package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.services.WarehouseApi;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-15T20:24:14.874537Z[Etc/UTC]")
@Controller
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    @Autowired
    WarehouseService warehouseService;
    private final NativeWebRequest request;

    @Autowired
    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    /**
     * GET /warehouse : Exports the hierarchy of Warehouse and Truck objects.
     *
     * @return Successful response (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or No hierarchy loaded yet. (status code 404)
     */
    @Operation(
            operationId = "exportWarehouses",
            summary = "Exports the hierarchy of Warehouse and Truck objects. ",
            tags = { "warehouse-management" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Warehouse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "No hierarchy loaded yet.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<Warehouse> exportWarehouses() {
        GeoCoordinate geoCoordinate = GeoCoordinate.builder().lat(0.11).lon(0.12).build();
        Hop hop = new Hop();
        hop.setCode("CODE6969"); hop.setDescription("Description");
        hop.setProcessingDelayMins(3); hop.setLocationName("Wien");
        hop.setLocationCoordinates(geoCoordinate); hop.setHopType("HopType");

        List<WarehouseNextHops> nextHops = new ArrayList<>();
        nextHops.add(WarehouseNextHops.builder()
                .hop(hop).traveltimeMins(4)
                .build());
        Warehouse warehouse = Warehouse.builder()
                .level(1).nextHops(nextHops).build();


        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);

    }



    /**
     * POST /warehouse : Imports a hierarchy of Warehouse and Truck objects.
     *
     * @param warehouse  (required)
     * @return Successfully loaded. (status code 200)
     *         or The operation failed due to an error. (status code 400)
     */
    @Operation(
            operationId = "importWarehouses",
            summary = "Imports a hierarchy of Warehouse and Truck objects. ",
            tags = { "warehouse-management" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successfully loaded."),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/warehouse",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<Void> importWarehouses(
            @Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse
    ) {
        try {
            warehouseService.importWarehouses(warehouse);
        } catch (Exception e) {
            log.error("Failed :( -> "  + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



    /**
     * GET /warehouse/{code} : Get a certain warehouse or truck by code
     *
     * @param code  (required)
     * @return Successful response (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or No hop with the specified id could be found. (status code 404)
     */
    @Operation(
            operationId = "getWarehouse",
            summary = "Get a certain warehouse or truck by code",
            tags = { "warehouse-management" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Hop.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "No hop with the specified id could be found.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse/{code}",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<Hop> getWarehouse(@Parameter(name = "code", description = "", required = true) @PathVariable("code") String code) {
        GeoCoordinate geoCoordinate = GeoCoordinate.builder().lat(0.1).lon(0.2).build();
        geoCoordinate.setLat(0.1); geoCoordinate.setLon(0.2);
        Hop hop = new Hop();
        hop.setCode("CODE6969"); hop.setDescription("Description");
        hop.setProcessingDelayMins(3); hop.setLocationName("Wien");
        hop.setLocationCoordinates(geoCoordinate); hop.setHopType("HopType");
        return new ResponseEntity<Hop>(hop, HttpStatus.OK);
    }

}
