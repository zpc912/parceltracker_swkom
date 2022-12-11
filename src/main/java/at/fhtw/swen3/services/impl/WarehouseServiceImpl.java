package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapperImpl;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;
    private WarehouseMapperImpl mapper;

    //public WarehouseServiceImpl(WarehouseRepository repo) { repository = repo; }

    public void submitNewWarehouse(Warehouse warehouse) {
        try {
            log.info("Submitting new warehouse: " + warehouse);
            Validator.getInstance().validate(warehouse);
            WarehouseEntity warehouseEntity = mapper.warehouseToWarehouseEntity(warehouse);
            repository.save(warehouseEntity);
        }catch (ConstraintViolationException exception){
            log.warn("Constraint violation: " + exception);
            return;
        }
    }

    @Override
    public Optional<List<Warehouse>> getWarehouses(){

        List<Warehouse> list = new ArrayList<>();

        repository.findAll().forEach(e -> list.add(mapper.warehouseEntityToWarehouse(e)));
        log.info("Return list of Warehouses");

        return Optional.of(list);
    }

    @Override
    public Optional<Warehouse> getWarehouseByCode (String code){

        List<WarehouseEntity> result = repository.findByCode(code);

        if(result.isEmpty()){
            log.warn("Warehouses by code are empty");
            return Optional.empty();
        }

        log.info("Return Warehouses by code");

        return Optional.of(mapper.warehouseEntityToWarehouse(result.get(0)));
    }

    @Override
    public void saveWarehouse(Warehouse warehouse){

        System.out.println(warehouse);

        WarehouseEntity warehouseEntity = mapper.warehouseToWarehouseEntity(warehouse);

        System.out.println(warehouseEntity);

        repository.save(warehouseEntity);
    }
}
