package web_app.service;

import web_app.entity.ProductEntity;
import web_app.exception.NotFoundEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_app.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService implements BaseService<ProductEntity> {
    private final ProductRepository repository;

    @Override
    public void createOne(ProductEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(ProductEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ProductEntity findOneById(UUID id) throws NotFoundEntityException {
        return repository.findById(id).orElseThrow(() -> new NotFoundEntityException(id));
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
