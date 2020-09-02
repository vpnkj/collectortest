package dk.vp.collectortest.service;

import dk.vp.collectortest.domain.CollectorModel;
import dk.vp.collectortest.repository.CollectorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class CollectorService {

    private final CollectorRepository collectorRepository;

    public CollectorService(CollectorRepository collectorRepository) {
        this.collectorRepository = collectorRepository;
    }

    public Optional<CollectorModel> getCollector(String isin) {
        return collectorRepository.findOneByIsin(isin);
    }

    public CollectorModel createCollector(CollectorModel collectorModel) {
        return collectorRepository.save(collectorModel);
    }

    public void deleteCollector(String isin) {
        collectorRepository.deleteByIsin(isin);
    }

    public List<CollectorModel> getAllCollectors() {
        return collectorRepository.findAll();
    }
}
