package ru.itis.javalab.repositories;

import com.zaxxer.hikari.HikariDataSource;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

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
    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);


    private final RowMapper<User> usersRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .username(row.getString("username"))
            .password(row.getString("password"))
            .UUID(row.getString("UUID"))
            .build();

    @Override
    public void update(Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, String.valueOf(args[0]));
            statement.setString(2, String.valueOf(args[1]));
            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                // ignore
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                // ignore
            }
        }
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public void save(Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SAVE);
            statement.setString(1, String.valueOf(args[0]));
            statement.setString(2, String.valueOf(args[1]));
            statement.setString(3, String.valueOf(args[2]));
            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                // ignore
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                // ignore
            }
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_USERNAME);
            statement.setString(1, username);
            resultSet = statement.executeQuery(SQL_FIND_ALL);
            return Optional.ofNullable(usersRowMapper.mapRow(resultSet));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
        }
    }


    @Override
    public List<User> findAll() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(usersRowMapper.mapRow(resultSet));
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
        }
    }

//    @Override
//    public List<User> findAllByAge(int age) {
//        // TODO: вместо этого написать return template.query(SQL_FIND_ALL_BY_AGE, usersRowMapper, age)
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = dataSource.getConnection();
//            statement = connection.prepareStatement(SQL_FIND_ALL_BY_AGE);
//            statement.setInt(1, age);
//            resultSet = statement.executeQuery();
//
//            List<User> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                result.add(usersRowMapper.mapRow(resultSet));
//            }
//
//            return result;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException throwables) {
//                    //ignore
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException throwables) {
//                    // ignore
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException throwables) {
//                    // ignore
//                }
//            }
//        }
//    }

    @Override
    public List<User> findAllByAge(int age) {
        return template.query(SQL_FIND_ALL_BY_AGE, usersRowMapper, age);
    }

//    @Override
//    public List<User> findAll() {
//        return template.query(SQL_FIND_ALL, usersRowMapper);
//    }


}
