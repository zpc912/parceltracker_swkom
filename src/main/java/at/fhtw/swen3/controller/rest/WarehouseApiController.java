package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-15T20:24:14.874537Z[Etc/UTC]")
@Controller
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    @Autowired
    private final NativeWebRequest request;

    @Autowired
    private final WarehouseService warehouseService;

    public WarehouseApiController(NativeWebRequest nativeWebRequest, WarehouseService warehouseService){
        this.request = nativeWebRequest;
        this.warehouseService = warehouseService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Warehouse> exportWarehouses(){
        log.info("exportWarehouses called.");

        Optional<List<Warehouse>> result = warehouseService.getWarehouses();

        if(!result.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(result.get().isEmpty()){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.OK);
        }


        return new ResponseEntity<>(result.get().get(0), HttpStatus.OK);
    }

    //Changed Interface Type to Warehouse
    @Override
    public ResponseEntity<Hop> getWarehouse(String code){
        log.info("getWarehouse called.");

        Optional<Warehouse> result = warehouseService.getWarehouseByCode(code);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);

        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse){
        log.info("importWarehouses called.");

        //warehouseService.saveWarehouse(warehouse);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
