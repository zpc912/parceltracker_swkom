package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.NewParcelInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewParcelInfoRepository extends JpaRepository<NewParcelInfoEntity, Long> {

    @Override
    Optional<NewParcelInfoEntity> findById(Long id);

    @Override
    List<NewParcelInfoEntity> findAll();

    @Override
    <S extends NewParcelInfoEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
