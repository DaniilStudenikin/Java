package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .firstName(row.getString("username"))
            .lastName(row.getString("password"))
            .UUID(row.getString("UUID"))
            .build();

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from some_site";
    //language=SQL
    private static final String SQL_FIND_ALL_BY_AGE = "select * from students where age = ?";
    //language=SQL
    private static final String SQL_SAVE = "insert into some_site(username, password, uuid) values(?, ?, ?)";
    //language=SQL
    private static final String SQL_FIND_BY_USERNAME = "select * from some_site where username=?";
    //language=SQL
    private static final String SQL_UPDATE = "update some_site set uuid=? where username=?";
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from some_site where id=?";
    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from students order by id limit :limit offset :offset";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException ex) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(SQL_FIND_BY_USERNAME, userRowMapper, username);
        } catch (EmptyResultDataAccessException ex) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(Object... args) {
        jdbcTemplate.update(SQL_UPDATE, args[0], args[1]);
    }

    @Override
    public void save(Object... args) {
        jdbcTemplate.update(SQL_SAVE, args[0], args[1], args[2]);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public List<User> findAllByAge(int age) {
        return jdbcTemplate.query(SQL_FIND_ALL_BY_AGE, userRowMapper, age);
    }
}
