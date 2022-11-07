package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {

    @Override
    Optional<ParcelEntity> findById(Long id);

    @Override
    List<ParcelEntity> findAll();

    @Override
    <S extends ParcelEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
