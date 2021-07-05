package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.*;
import ru.itis.javalab.repositories.*;

import java.util.List;
import java.util.Optional;

import static ru.itis.javalab.dto.UserDto.from;

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
    public void save(Object... args) {
        usersRepository.save(args);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {

        return from(usersRepository.findAll(page, size));
    }

    public List<User> getUserByAge() {
        return usersRepository.findAllByAge(19);
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User
                .builder());
    }
}
