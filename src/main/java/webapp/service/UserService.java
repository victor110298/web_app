package webapp.service;

import webapp.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.exception.UserNotFoundException;
import webapp.repository.UserRepository;

import java.util.List;

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
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity findOneById(Long id)  {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    public UserEntity findOneByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
