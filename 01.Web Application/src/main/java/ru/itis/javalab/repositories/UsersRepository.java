package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    List<User> findAll(int page, int size);
    Optional<User> findByUsername(String username);
    void update(Object ... args);
    void save(Object ... args);
    List<User> findAll();

    List<User> findAllByAge(int age);
}
