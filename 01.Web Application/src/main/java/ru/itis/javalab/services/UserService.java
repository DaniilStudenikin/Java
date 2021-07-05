package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void update(Object ... args);
    Optional<User> findByUsername(String username);
    void save(Object ... args);
    List<User> getAllUsers();
    List<UserDto> getAllUsers(int page, int size);
    List<User> getUserByAge();
    void addUser(UserDto userDto);
}
