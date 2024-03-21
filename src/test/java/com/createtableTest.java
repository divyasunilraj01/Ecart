package com;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class createtableTest {

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Establish a connection to the database before each test
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jassignment", "root", "root");
    }

    @After
    public void tearDown() throws Exception {
        // Close the database connection after each test
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testCreateTable() throws ClassNotFoundException, SQLException {
        // Remove the table if it already exists
        dropTableIfExists(connection, "admin");

        // Create the table
        createtable.createTable(connection);

        // Verify if the table exists
        assertTrue(tableExists(connection, "admin"));
    }

    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        // Remove the table if it already exists
        dropTableIfExists(connection, "admin");

        // Create the table
        createtable.createTable(connection);

        // Insert a row into the table
        createtable.insertData(connection);

        // Verify if a row has been inserted
        assertTrue(rowExists(connection, "admin", "admin", "admin"));
    }

    // Utility method to check if a table exists
    private boolean tableExists(Connection connection, String tableName) throws SQLException {
        return connection.getMetaData().getTables(null, null, tableName, null).next();
    }

    // Utility method to check if a row exists in a table
    private boolean rowExists(Connection connection, String tableName, String username, String password) throws SQLException {
        Statement statement = connection.createStatement();
        String query = String.format("SELECT * FROM %s WHERE username = '%s' AND password = '%s'", tableName, username, password);
        return statement.executeQuery(query).next();
    }

    // Utility method to drop a table if it exists
    private void dropTableIfExists(Connection connection, String tableName) throws SQLException {
        if (tableExists(connection, tableName)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE " + tableName);
        }
    }
}
