package ru.itis.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itis.hibernate.models.Course;

public class MainForStates {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Course course = Course.builder()
                .title("Java")
                .build();
        //TRANSIENT

        //PERSISTENT
        session.save(course);
        course.setTitle("Новое название курса");
        session.saveOrUpdate(course);
        session.close();


        // DETACHED
        System.out.println(course);
    }
}
