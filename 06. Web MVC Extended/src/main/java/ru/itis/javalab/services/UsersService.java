package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;


public interface UsersService {
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsers(Integer page, Integer size);
    void addUser(UserDto userDto);

    UserDto getUser(Long id);
}
