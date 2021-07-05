package ru.itis.javalab.services;

public class MailsServiceImpl implements MailsService {
    @Override
    public void sendMail(String email, String message) {
        System.err.println("Сообщение <" +message +  "> отправлено: " + email);
    }
}
