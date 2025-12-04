package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String args[]) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/cdac";
        String username = "root";
        String password = "cdac@123";

        Connection con = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get connection
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Successfully connected to MySQL Database");
            } else {
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            System.out.println("Database Connection failed");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {  
                e.printStackTrace();
            }
        }
    }
}
