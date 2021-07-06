package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends CrudRepository<User> {
    List<User> findAll();

    void save(User user);

    List<User> findAll(int page, int size);

    List<User> findAllByAge(Integer age);

    Optional<User> findFirstByFirstnameAndLastname(String firstName, String lastName);
}
