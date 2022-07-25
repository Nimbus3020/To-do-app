package org.example.todoapplication.model.dao;

import org.example.todoapplication.model.UserDetails;
import org.example.todoapplication.model.utsils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class contains JDBC code which stores UserDetails data into Userdetails table
 */
public class UserDetailsDAO {

    public int registerEmployee(UserDetails employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users"
                + "  (first_name, last_name, username, password) VALUES "
                + " (?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
}
