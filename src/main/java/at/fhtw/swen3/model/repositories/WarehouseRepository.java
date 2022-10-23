package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {

    @Override
    Optional<WarehouseEntity> findById(Long id);

    @Override
    List<WarehouseEntity> findAll();

    @Override
    <S extends WarehouseEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
