//package ru.itis.javalab.repositories.old;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SimpleJdbcTemplate {
//    private DataSource dataSource;
//
//    public SimpleJdbcTemplate(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
//        Connection connection = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//        try {
//
//            connection = dataSource.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            for (int i = 1; i < args.length + 1; i++) {
//                preparedStatement.setObject(i, args[i]);
//            }
//            resultSet = preparedStatement.executeQuery();
//
//            List<T> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                result.add(rowMapper.mapRow(resultSet));
//            }
//            return result;
//        } catch (SQLException e) {
//            throw new IllegalArgumentException();
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException ex) {
//                    //ignore
//                }
//            }
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException ex) {
//                    //ignore
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    //ignore
//                }
//            }
//        }
//    }
//}
