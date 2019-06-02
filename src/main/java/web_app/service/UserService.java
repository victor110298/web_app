package web_app.service;

import web_app.entity.UserEntity;
import web_app.exception.NotFoundEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_app.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements BaseService<UserEntity> {
    private final UserRepository repository;

    @Override
    public void createOne(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity findOneById(UUID id) throws NotFoundEntityException {
        return repository.findById(id).orElseThrow(() -> new NotFoundEntityException(id));
    }

    public UserEntity findOneByEmail(String email) throws NotFoundEntityException {
        return repository.findByEmail(email).orElseThrow(NotFoundEntityException::new);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
