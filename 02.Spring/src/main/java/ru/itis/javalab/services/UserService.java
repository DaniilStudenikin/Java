package ru.itis.javalab.services;

public interface UserService {
    void signUp(String firstName,String lastName, String email, String password);
    void signIn(String email, String password);
}
