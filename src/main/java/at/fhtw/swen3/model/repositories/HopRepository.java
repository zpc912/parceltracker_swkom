package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HopRepository extends JpaRepository<HopEntity, Long> {

    @Override
    Optional<HopEntity> findById(Long id);

    @Override
    List<HopEntity> findAll();

    @Override
    <S extends HopEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
