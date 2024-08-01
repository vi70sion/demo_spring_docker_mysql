package com.example.demo_spring_linux.repository;

import com.example.demo_spring_linux.model.User;
import static com.example.demo_spring_linux.Constants.*;
import java.sql.*;

public class UserRepository {

    private static Connection _connection;

    public UserRepository() {
    }

    public static void sqlConnection() {
        try {
            _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // connection issues
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // handle any other exceptions
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public User getUser(int id) {
        try {
            sqlConnection();
            User user = new User();
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = _connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            boolean hasResults = resultSet.next();
            if(!hasResults) return null;
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            return user;
        } catch (SQLException e) {
            //
        }
        return null;
    }


}
