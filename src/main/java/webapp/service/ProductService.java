package webapp.service;

import webapp.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.exception.ProductNotFountException;
import webapp.repository.ProductRepository;

import java.util.List;

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
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ProductEntity findOneById(Long id)  {
        return repository.findById(id).orElseThrow(() -> new ProductNotFountException());
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
