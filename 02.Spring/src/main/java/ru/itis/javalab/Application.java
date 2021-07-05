package ru.itis.javalab;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.itis.javalab.front.Front;

public class Application {
    public static void main(String[] args) {
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader("C:\\Users\\fastrapier\\Desktop\\Java\\02.Spring\\src\\main\\resources\\db.properties"));
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
//        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
//        hikariConfig.setUsername(properties.getProperty("db.username"));
//        hikariConfig.setPassword(properties.getProperty("db.password"));
//        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(namedParameterJdbcTemplate);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        MailsService mailsService = new MailsServiceImpl();
//        UserService userService = new UserServiceImpl(usersRepository, passwordEncoder, mailsService);
//        Front front = new FrontImpl(userService);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Front front = context.getBean(Front.class);
        front.run();
    }
}
