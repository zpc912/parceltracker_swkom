package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TruckRepository extends JpaRepository<TruckEntity, Long> {

    @Override
    Optional<TruckEntity> findById(Long id);

    @Override
    List<TruckEntity> findAll();

    @Override
    <S extends TruckEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
