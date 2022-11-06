package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {

    @Override
    Optional<WarehouseNextHopsEntity> findById(Long id);

    @Override
    List<WarehouseNextHopsEntity> findAll();

    @Override
    <S extends WarehouseNextHopsEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}