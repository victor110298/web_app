package webapp.service;

import webapp.entity.ManufacturerEntity;
import webapp.exception.ManufacturerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.mapper.ManufacturerMapper;
import webapp.repository.ManufacturerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManufacturerService implements BaseService<ManufacturerEntity> {
    private final ManufacturerRepository repository;
    ManufacturerMapper mapper = new ManufacturerMapper();

    @Override
    public void createOne(ManufacturerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(ManufacturerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ManufacturerEntity findOneById(Long id) {
        return repository.findById(id).orElseThrow(ManufacturerNotFoundException::new);
    }

    @Override
    public List<ManufacturerEntity> findAll() {
        return repository.findAll();
    }
}
