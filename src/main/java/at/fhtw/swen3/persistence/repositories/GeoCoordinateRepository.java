package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateEntity, Long> {

    @Override
    Optional<GeoCoordinateEntity> findById(Long id);

    @Override
    List<GeoCoordinateEntity> findAll();

    @Override
    <S extends GeoCoordinateEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
