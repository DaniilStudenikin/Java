package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.*;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "SELECT * FROM account WHERE email = :email limit 1";
    //language=SQL
    private static final String SQL_INSERT = "INSERT INTO account(email, first_name, last_name, hash_password) " +
            "VALUES (:email, :firstName, :lastName, :hashPassword)";

    //private JdbcTemplate jdbcTemplate;
    public NamedParameterJdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        //this.jdbcTemplate = template;
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    private RowMapper<User> userRowMapper = (row, rowNumber) ->
            User.builder()
                    .id(row.getLong("id"))
                    .firstName(row.getString("first_name"))
                    .lastName(row.getString("last_name"))
                    .email(row.getString("email"))
                    .hashPassword(row.getString("hash_password"))
                    .build();

    @Override
    public void save(User entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", entity.getEmail());
        params.put("firstName", entity.getFirstName());
        params.put("lastName", entity.getLastName());
        params.put("hashPassword", entity.getHashPassword());
        jdbcTemplate.update(SQL_INSERT, params);
        //TODO: вставка id после insert-a
        //entity.setId(сгенерированный в базе id)
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL, Collections.singletonMap("email", email), userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
