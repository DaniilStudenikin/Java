package ru.itis.javalab.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.time.LocalDateTime;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private MailsService mailsService;

    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder, MailsService mailsService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailsService = mailsService;
    }

    @Override
    public void signUp(String firstName, String lastName, String email, String password) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .hashPassword(passwordEncoder.encode(password))
                .build();
        usersRepository.save(user);
    }

    @Override
    public void signIn(String email, String password) {
        usersRepository.findOneByEmail(email).ifPresent(user -> {
            if (passwordEncoder.matches(password, user.getHashPassword())) {
                mailsService.sendMail(email, "был выполене вход" + LocalDateTime.now().toString());
            }
        });
    }
}
