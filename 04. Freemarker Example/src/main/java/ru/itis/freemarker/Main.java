package ru.itis.freemarker;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new FileTemplateLoader(new File("C:\\Users\\fastrapier\\Desktop\\Java\\04. Freemarker Example\\src\\main\\resources")));

        Template template = configuration.getTemplate("template.ftlh");

        User user = User.builder()
                .id(1L)
                .name("Daniil")
                .age(19)
                .build();

        List<User> users = new ArrayList<>();

        users.add(User.builder().id(2L).name("Сабина").age(20).build());
        users.add(User.builder().id(3L).name("Александра").age(19).build());
        users.add(User.builder().id(4L).name("Анастасия").age(19).build());
        users.add(User.builder().id(5L).name("Шамиль").age(19).build());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("user", user);
        attributes.put("users", users);

        FileWriter fileWriter = new FileWriter("output.txt");
        template.process(attributes, fileWriter);
    }
}
