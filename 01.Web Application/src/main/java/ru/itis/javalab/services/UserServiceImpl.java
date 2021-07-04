package ru.itis.javalab.services;
import ru.itis.javalab.models.*;
import ru.itis.javalab.repositories.*;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
    @Override
    public void update(Object... args) {
        usersRepository.update(args);
    }
    @Override
    public void save(Object ... args) {
        usersRepository.save(args);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
    public List<User> getUserByAge() {
        return usersRepository.findAllByAge(19);
    }
}
