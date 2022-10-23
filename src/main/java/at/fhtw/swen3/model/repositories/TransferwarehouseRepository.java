package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {

    @Override
    Optional<TransferwarehouseEntity> findById(Long id);

    @Override
    List<TransferwarehouseEntity> findAll();

    @Override
    <S extends TransferwarehouseEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
