package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipientRepository extends JpaRepository<RecipientEntity, Long> {

    @Override
    Optional<RecipientEntity> findById(Long id);

    @Override
    List<RecipientEntity> findAll();

    @Override
    <S extends RecipientEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
