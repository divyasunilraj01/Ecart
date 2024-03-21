package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static Connection conn = null;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jassignment";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
