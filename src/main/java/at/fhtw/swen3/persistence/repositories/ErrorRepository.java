package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ErrorRepository extends JpaRepository<ErrorEntity, Long> {

    @Override
    Optional<ErrorEntity> findById(Long id);

    @Override
    List<ErrorEntity> findAll();

    @Override
    <S extends ErrorEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}
