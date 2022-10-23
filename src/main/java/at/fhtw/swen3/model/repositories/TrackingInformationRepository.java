package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.TrackingInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrackingInformationRepository extends JpaRepository<TrackingInformationEntity, Long> {

    @Override
    Optional<TrackingInformationEntity> findById(Long id);

    @Override
    List<TrackingInformationEntity> findAll();

    @Override
    <S extends TrackingInformationEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
