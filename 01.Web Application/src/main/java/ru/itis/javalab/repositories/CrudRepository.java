package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(Object ... args);
    Optional<T> findByUsername(String username);
    void update(Object ... args);

    void delete(T entity);

    Optional<T> findById(Long id);

    List<User> findAllByAge(int age);

    List<T> findAll();
}
