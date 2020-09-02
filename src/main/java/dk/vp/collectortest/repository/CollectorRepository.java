package dk.vp.collectortest.repository;

import dk.vp.collectortest.domain.CollectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectorRepository extends JpaRepository<CollectorModel, Long>, JpaSpecificationExecutor<CollectorModel> {

    Optional<CollectorModel> findOneByIsin(String isin);

    void deleteByIsin(String isin);

    List<CollectorModel> findAll();
}
