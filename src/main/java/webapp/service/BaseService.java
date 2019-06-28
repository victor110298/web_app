package webapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {
    void createOne(T entity);

    void updateOne(T entity);

    void deleteOneById(Long id);

    T findOneById(Long id);

    List<T> findAll();
}
